using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class CrearCuentaVM : ObservableObject
    {
        [ObservableProperty] private string _nombre;
        [ObservableProperty] private string _email;
        [ObservableProperty] private string _telefono;
        [ObservableProperty] private string _password;
        [ObservableProperty] private string _confirmarPassword;

        [ObservableProperty] private string _ubicacion;
        [ObservableProperty] private string _horario;
        [ObservableProperty] private string _descripcion;

        [ObservableProperty] private string _imagen; // base64

        [RelayCommand]
        private void Confirmar()
        {
            // Validar contraseñas
            if (Password != ConfirmarPassword)
            {
                MessageBox.Show("Las contraseñas no coinciden");
                return;
            }

            // Validar campos obligatorios
            if (string.IsNullOrWhiteSpace(Nombre) ||
                string.IsNullOrWhiteSpace(Email) ||
                string.IsNullOrWhiteSpace(Password) ||
                string.IsNullOrWhiteSpace(Telefono) ||
                string.IsNullOrWhiteSpace(Ubicacion) ||
                string.IsNullOrWhiteSpace(Horario) ||
                string.IsNullOrWhiteSpace(Descripcion) ||
                string.IsNullOrWhiteSpace(Imagen))
            {
                MessageBox.Show("Debes rellenar todos los campos y subir una imagen.");
                return;
            }

            // Crear restaurante
            Restaurante nuevoRestaurante = new Restaurante
            {
                Nombre = Nombre,
                Email = Email,
                Telefono = Telefono,
                Password = Password,
                Ubicacion = Ubicacion,
                Horario = Horario,
                Descripcion = Descripcion,
                Imagen = Imagen
            };

            ApiRestService.PostRestaurante(nuevoRestaurante);

            MessageBox.Show("Cuenta creada correctamente");

            // 🔹 Login automático con la cuenta recién creada
            var usuario = ApiRestService.Login(Email, Password);

            if (usuario == null)
            {
                MessageBox.Show("No se pudo iniciar sesión automáticamente.");
                return;
            }

            // 🔹 Guardar usuario en MainWindowVM
            WeakReferenceMessenger.Default.Send(
                new UsuarioLogueadoMessage(usuario)
            );

            // 🔹 Navegar a principal
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
        }

        [RelayCommand]
        private void SeleccionarImagen()
        {
            Imagen = EcoBite.Helpers.ImageHelper.PickImageAsBase64();

            if (Imagen == null)
                MessageBox.Show("No se seleccionó imagen");
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("INICIO"));
        }
    }
}