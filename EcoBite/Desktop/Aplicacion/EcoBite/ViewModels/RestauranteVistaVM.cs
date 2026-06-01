
using CommunityToolkit.Mvvm.ComponentModel;

using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Collections.ObjectModel;

namespace EcoBite.ViewModels
{
    public partial class RestauranteVistaVM : ObservableObject
    {
        // Restaurante seleccionado (viene de MainWindowVM)
        [ObservableProperty]
        private Restaurante _restaurante;

        // Recetas SOLO de este restaurante
        public ObservableCollection<Receta> Recetas { get; }

        [ObservableProperty]
        private Receta recetaActual;

        private int indexReceta = 0;

        //Recibe el viewModel de MainWindow para poder acceder a sus propiedades para mostrar la información
        public RestauranteVistaVM(MainWindowVM mainVM)
        {
            Restaurante = mainVM.RestauranteSeleccionado;

            // 🔥 Ahora las recetas se cargan desde la API
            var lista = ApiRestService.GetRecetasByRestaurante(Restaurante.IdRestaurante);

            Recetas = new ObservableCollection<Receta>(lista);

            if (Recetas.Any())
                RecetaActual = Recetas.First();
        }

        // Flechas carta
        [RelayCommand]
        private void SiguienteReceta()
        {
            if (!Recetas.Any()) return;

            indexReceta = (indexReceta + 1) % Recetas.Count;
            RecetaActual = Recetas[indexReceta];
        }

        [RelayCommand]
        private void AnteriorReceta()
        {
            if (!Recetas.Any()) return;

            indexReceta = (indexReceta - 1 + Recetas.Count) % Recetas.Count;
            RecetaActual = Recetas[indexReceta];
        }

        // Flecha volver
        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(new CambiarVistaMessage("PRINCIPAL"));
        }

        [RelayCommand]
        private void IrAConfiguracion()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("CONFIGURACION")
            );
        }

        [RelayCommand]
        private void IrAAcercaDe()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("ACERCA_DE")
            );
        }
        [RelayCommand]
        private void CerrarSesion()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("INICIO")
            );
        }
        [RelayCommand]
        private void AbrirReceta()
        {
            if (RecetaActual != null)
                WeakReferenceMessenger.Default.Send(new NavegarARecetaMessage(RecetaActual));
        }
    }
}
