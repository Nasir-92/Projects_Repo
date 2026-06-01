using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Collections.ObjectModel;

namespace EcoBite.ViewModels
{
    public partial class PrincipalVM : ObservableObject
    {

        [ObservableProperty]
        private ObservableCollection<Restaurante> restaurantesSugeridos = new();

        [ObservableProperty]
        private bool haySugerencias;

        private MainWindowVM mainWindow;

        private List<Restaurante> restaurantesBusqueda;

        [ObservableProperty]
        private ObservableCollection<Restaurante> restaurantes;

        [ObservableProperty]
        private ObservableCollection<Receta> recetas;

        [ObservableProperty]
        private Restaurante restauranteActual;

        [ObservableProperty]
        private Receta recetaActual;

        [ObservableProperty]
        private string textoBusqueda;

        [ObservableProperty]
        private AuthUser usuarioLogueado;

        private int indiceRestaurante = 0;
        private int indiceReceta = 0;

        public PrincipalVM(MainWindowVM mainWindow)
        {
            this.mainWindow = mainWindow;

            WeakReferenceMessenger.Default.Register<UsuarioLogueadoMessage>(
                this,
                (r, m) => { usuarioLogueado = m.Value; }
            );

            Restaurantes = new ObservableCollection<Restaurante>(ApiRestService.GetRestaurantes());

            // 🔹 restauramos recetas como antes
            Recetas = new ObservableCollection<Receta>(ApiRestService.GetRecetas());

            restaurantesBusqueda = Restaurantes.ToList();

            RestauranteActual = Restaurantes.FirstOrDefault();

            //Id de restaurante que le pasamos para la vista Configuracion
            //if (RestauranteActual != null)
            //{
            //    mainWindow.IdRestauranteActual = RestauranteActual.IdRestaurante;
            //}
            RecetaActual = Recetas.FirstOrDefault();


            CargarRecetasDelRestaurante();
        }

        [RelayCommand]
        private void SiguienteRestaurante()
        {
            if (Restaurantes.Count == 0) return;

            indiceRestaurante++;

            if (indiceRestaurante >= Restaurantes.Count)
                indiceRestaurante = 0;

            RestauranteActual = Restaurantes[indiceRestaurante];

            CargarRecetasDelRestaurante();
        }

        [RelayCommand]
        private void AnteriorRestaurante()
        {
            if (Restaurantes.Count == 0) return;

            indiceRestaurante--;

            if (indiceRestaurante < 0)
                indiceRestaurante = Restaurantes.Count - 1;

            RestauranteActual = Restaurantes[indiceRestaurante];

            CargarRecetasDelRestaurante();
        }

        [RelayCommand]
        private void SiguienteReceta()
        {
            if (Recetas.Count == 0) return;

            indiceReceta++;

            if (indiceReceta >= Recetas.Count)
                indiceReceta = 0;

            RecetaActual = Recetas[indiceReceta];
        }

        [RelayCommand]
        private void AnteriorReceta()
        {
            if (Recetas.Count == 0) return;

            indiceReceta--;

            if (indiceReceta < 0)
                indiceReceta = Recetas.Count - 1;

            RecetaActual = Recetas[indiceReceta];
        }

        [RelayCommand]
        private void AbrirRestaurante()
        {
            if (RestauranteActual == null) return;

            WeakReferenceMessenger.Default.Send(
                new NavegarARestauranteMessage(RestauranteActual)
            );
        }

        [RelayCommand]
        private void AbrirReceta()
        {
            if (RecetaActual == null) return;

            WeakReferenceMessenger.Default.Send(
                new NavegarARecetaMessage(RecetaActual)
            );
        }

        [RelayCommand]
        private void AbrirRestauranteSugerido(Restaurante restaurante)
        {
            if (restaurante == null) return;

            WeakReferenceMessenger.Default.Send(
                new NavegarARestauranteMessage(restaurante)
            );

            TextoBusqueda = "";
            RestaurantesSugeridos.Clear();
            HaySugerencias = false;
        }

        partial void OnTextoBusquedaChanged(string value)
        {
            if (string.IsNullOrWhiteSpace(value))
            {
                RestaurantesSugeridos.Clear();
                HaySugerencias = false;
                return;
            }

            var resultados = restaurantesBusqueda
                .Where(r => r.Nombre.Contains(value, StringComparison.OrdinalIgnoreCase))
                .Take(5)
                .ToList();

            RestaurantesSugeridos = new ObservableCollection<Restaurante>(resultados);

            HaySugerencias = resultados.Count > 0;
        }
        private void CargarRecetasDelRestaurante()
        {
            if (RestauranteActual == null)
                return;

            var recetasRestaurante = ApiRestService.GetRecetasByRestaurante(RestauranteActual.IdRestaurante);

            Recetas = new ObservableCollection<Receta>(recetasRestaurante);

            indiceReceta = 0;
            RecetaActual = Recetas.FirstOrDefault();
        }

        [RelayCommand]
        private void CerrarSesion()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("INICIO")
            );
        }

        [RelayCommand]
        private void IrACrearReceta()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("CREAR_RECETA")
            );
            WeakReferenceMessenger.Default.Send(new IdRestauranteMessage(RestauranteActual.IdRestaurante));
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
    }
}