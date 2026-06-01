using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class ConfiguracionVM : ObservableObject
    {
        [ObservableProperty]
        private string vistaAnterior;

        public ConfiguracionVM()
        {
        }

        public ConfiguracionVM(string vistaOrigen)
        {
            VistaAnterior = vistaOrigen;
        }

        [ObservableProperty] private int idRestaurante;
        [ObservableProperty] private string nombre;
        [ObservableProperty] private string email;
        [ObservableProperty] private string telefono;
        [ObservableProperty] private string password;
        [ObservableProperty] private string confirmarPassword;
        [ObservableProperty] private string ubicacion;
        [ObservableProperty] private string horario;
        [ObservableProperty] private string descripcion;
        [ObservableProperty] private string imagen;

        [RelayCommand]
        private void SeleccionarImagen()
        {
            Imagen = EcoBite.Helpers.ImageHelper.PickImageAsBase64();

            if (Imagen == null)
                MessageBox.Show("No se seleccionó imagen");
        }
        [RelayCommand]
        private void GuardarConfiguracion()
        {
            if (string.IsNullOrWhiteSpace(Nombre) ||
                string.IsNullOrWhiteSpace(Email) ||
                string.IsNullOrWhiteSpace(Telefono) ||
                string.IsNullOrWhiteSpace(Ubicacion) ||
                string.IsNullOrWhiteSpace(Horario))
            {
                MessageBox.Show("Completa todos los campos obligatorios.");
                return;
            }

            if (!string.IsNullOrWhiteSpace(Password) ||
                !string.IsNullOrWhiteSpace(ConfirmarPassword))
            {
                if (Password != ConfirmarPassword)
                {
                    MessageBox.Show("Las contraseñas no coinciden.");
                    return;
                }
            }

            if (IdRestaurante == 0)
            {
                MessageBox.Show("Error: restaurante no identificado.");
                return;
            }

            Restaurante nuevoRestaurante = new Restaurante
            {
                IdRestaurante = IdRestaurante,
                Nombre = Nombre,
                Email = Email,
                Telefono = Telefono,
                Password = Password,
                Ubicacion = Ubicacion,
                Horario = Horario,
                Descripcion = Descripcion,
                Imagen = Imagen
            };

            bool ok = ApiRestService.UpdateConfiguration(IdRestaurante, nuevoRestaurante);

            if (ok)
            {
                MessageBox.Show("Configuración guardada correctamente");
            }
            else
            {
                MessageBox.Show("Error al guardar la configuración");
            }
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(
                   new CambiarVistaMessage("PRINCIPAL")
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