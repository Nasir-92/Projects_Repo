using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class RecetaVistaVM : ObservableObject
    {
        private readonly MainWindowVM mainVM;

        [ObservableProperty]
        private Receta _receta;

        [ObservableProperty]
        private Restaurante _restaurante;

        [ObservableProperty]
        private bool _puedeEliminar;

        public RecetaVistaVM(MainWindowVM mainVM)
        {
            this.mainVM = mainVM;

            Receta = mainVM.RecetaSeleccionada;

            var listaRestaurantes = ApiRestService.GetRestaurantes();

            Restaurante = listaRestaurantes
                .FirstOrDefault(r => r.IdRestaurante == Receta.IdRestaurante);

            // Solo puede eliminar si:
            // 1) hay usuario logueado
            // 2) su rol es RESTAURANTE
            // 3) la receta pertenece a ese restaurante
            PuedeEliminar =
                mainVM.UsuarioActual != null &&
                (mainVM.UsuarioActual.Rol == "ADMIN" ||
                (mainVM.UsuarioActual.Rol == "RESTAURANTE" &&
                 mainVM.UsuarioActual.IdRestaurante.HasValue &&
                 mainVM.UsuarioActual.IdRestaurante.Value == Receta.IdRestaurante));
                //mainVM.UsuarioActual.Rol == "RESTAURANTE" &&
                //mainVM.UsuarioActual.IdRestaurante.HasValue &&
                //mainVM.UsuarioActual.IdRestaurante.Value == Receta.IdRestaurante;
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
        }

        [RelayCommand]
        private void Eliminar()
        {
            if (!PuedeEliminar)
            {
                MessageBox.Show("No tienes permiso para eliminar esta receta.");
                return;
            }

            var resultado = MessageBox.Show(
                "¿Seguro que quieres eliminar esta receta?",
                "Confirmar eliminación",
                MessageBoxButton.YesNo,
                MessageBoxImage.Warning
            );

            if (resultado != MessageBoxResult.Yes)
                return;

            bool ok = ApiRestService.DeleteReceta(Receta.IdReceta);

            if (!ok)
            {
                MessageBox.Show("No se pudo eliminar la receta.");
                return;
            }

            MessageBox.Show("Receta eliminada correctamente.");

            WeakReferenceMessenger.Default.Send(
                new RecetasActualizadasMessage()
            );

            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
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
        private void AbrirRestaurante()
        {
            if (Restaurante != null)
                WeakReferenceMessenger.Default.Send(new NavegarARestauranteMessage(Restaurante));
        }
    }
}