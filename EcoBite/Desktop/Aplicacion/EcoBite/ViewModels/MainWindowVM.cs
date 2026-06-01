using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace EcoBite.ViewModels
{
    public partial class MainWindowVM : ObservableRecipient
    {

        [ObservableProperty]
        private string codigoRecuperacion;

        [ObservableProperty]
        private string emailRecuperacion;
        [ObservableProperty]
        private UserControl _vistaActual;

        [ObservableProperty]
        private AuthUser usuarioActual;

        [ObservableProperty]
        private Restaurante restauranteSeleccionado;

        [ObservableProperty]
        private Receta recetaSeleccionada;
        public MainWindowVM()
        {
            VistaActual = new Inicio();
            WeakReferenceMessenger.Default.Register<UsuarioLogueadoMessage>(this, (r, m) =>
            {
                UsuarioActual = m.Value;
            });

            WeakReferenceMessenger.Default.Register<CambiarVistaMessage>(this, (r, m) =>
            {
                switch (m.Value)
                {
                    case "INICIO":
                        VistaActual = new Inicio();
                        break;

                    case "PRINCIPAL":
                        {
                            var vista = new Principal();
                            vista.DataContext = new PrincipalVM(this);
                            VistaActual = vista;
                        }
                        break;

                    case "CREAR_CUENTA":
                        VistaActual = new CrearCuenta();
                        break;

                    case "ACERCA_DE":
                        VistaActual = new AcercaDe();
                        break;

                    case "CONFIGURACION":
                        {
                            var vista = new Configuracion();

                            string vistaOrigen = VistaActual switch
                            {
                                Principal => "PRINCIPAL",
                                RestauranteVista => "RESTAURANTE",
                                RecetaVista => "RECETA",
                                CrearReceta => "CREAR_RECETA",
                                _ => "PRINCIPAL"
                            };

                            var vm = new ConfiguracionVM(vistaOrigen);

                            if (UsuarioActual.IdRestaurante != null)
                            {
                                vm.IdRestaurante = UsuarioActual.IdRestaurante.Value;
                            }

                            vista.DataContext = vm;

                            VistaActual = vista;
                        }
                        break;

                    case "CREAR_RECETA":
                        {
                            var vista = new CrearReceta();
                            vista.DataContext = new CrearRecetaVM(this);
                            VistaActual = vista;
                        }
                        break;

                    case "RecuperarCuenta":
                        VistaActual = new RecuperarCuenta();
                        break;

                    case "INTRODUCIR_CODIGO":
                        VistaActual = new IntroducirCodigo();
                        break;

                    case "CAMBIAR_PASSWORD":
                        VistaActual = new CambiarPassword();
                        break;
                }
            });

            // Navegar a RESTAURANTE
            WeakReferenceMessenger.Default.Register<NavegarARestauranteMessage>(
                this, (r, m) =>
                {
                    RestauranteSeleccionado = m.Value;

                    var vista = new RestauranteVista();
                    vista.DataContext = new RestauranteVistaVM(this);

                    VistaActual = vista;
                });

            // Navegar a RECETA
            WeakReferenceMessenger.Default.Register<NavegarARecetaMessage>(
                this, (r, m) =>
                {
                    RecetaSeleccionada = m.Value;

                    var vista = new RecetaVista();
                    vista.DataContext = new RecetaVistaVM(this);

                    VistaActual = vista;
                });
        }
    }
}