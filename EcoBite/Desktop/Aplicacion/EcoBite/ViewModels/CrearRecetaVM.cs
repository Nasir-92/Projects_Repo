using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Helpers;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class CrearRecetaVM : ObservableObject
    {
        private readonly MainWindowVM mainVM;

        [ObservableProperty] private string _nombre;
        [ObservableProperty] private string _descripcion;
        [ObservableProperty] private string _pasos;
        [ObservableProperty] private string _imagen;
        [ObservableProperty]
        private int _idRestaurante;

        public CrearRecetaVM(MainWindowVM main)
        {
            mainVM = main;
            WeakReferenceMessenger.Default.Register<IdRestauranteMessage>(
       this,
       (r, m) =>
       {
           _idRestaurante = m.Value;
       }
   );
        }

        [RelayCommand]
        private void SeleccionarImagen()
        {
            Imagen = ImageHelper.PickImageAsBase64();

            if (Imagen == null)
                MessageBox.Show("No se seleccionó imagen");
        }

        [RelayCommand]
        private void Crear()
        {
            // VALIDACIÓN COMPLETA
            if (string.IsNullOrWhiteSpace(Nombre) ||
                string.IsNullOrWhiteSpace(Descripcion) ||
                string.IsNullOrWhiteSpace(Pasos) ||
                string.IsNullOrWhiteSpace(Imagen))
            {
                MessageBox.Show("Debes rellenar todos los campos y subir una imagen.");
                return;
            }

            if (mainVM.UsuarioActual?.IdRestaurante == null && mainVM.UsuarioActual?.IdAdmin == null)
            {
                MessageBox.Show("Solo los restaurantes pueden crear recetas");
                return;
            }

            Receta receta = new Receta
            {
                Nombre = Nombre,
                Descripcion = Descripcion,
                Pasos = Pasos,
                Imagen = Imagen,
                IdRestaurante = IdRestaurante
            };

            ApiRestService.PostReceta(receta);

            MessageBox.Show("Receta creada correctamente");

            WeakReferenceMessenger.Default.Send(
                new RecetasActualizadasMessage()
            );

            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
        }

        [RelayCommand]
        private void Cancelar()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL"));
        }
    }
}