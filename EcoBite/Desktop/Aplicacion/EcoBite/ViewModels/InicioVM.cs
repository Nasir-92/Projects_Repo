using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class InicioVM : ObservableObject
    {


        [ObservableProperty]
        private string _email;

        [ObservableProperty]
        private string _password;

        public InicioVM()
        {

        }

        [RelayCommand]
        private void Login()
        {
            // 1) ******USO DE APIREST PARA LOGIN
            AuthUser usuario = ApiRestService.Login(Email, Password);

            // 2) Si existe, login correcto => avisamos al MainWindowVM por mensajería
            if (usuario != null)
            {

                //Pasar el nombre de la ventana a mostrar
                WeakReferenceMessenger.Default.Send(new CambiarVistaMessage("PRINCIPAL"));
                //Pasar el usuario logueado
                WeakReferenceMessenger.Default.Send(new UsuarioLogueadoMessage(usuario));

            }
            else
            {
                // 3) Si no existe, login incorrecto
                MessageBox.Show(
                    "Email o contraseña incorrectos",
                    "Login",
                    MessageBoxButton.OK,
                    MessageBoxImage.Error
                );
            }
        }

        [RelayCommand]
        private void IrACrearCuenta()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("CREAR_CUENTA")
            );
        }

        [RelayCommand]
        private void IrARecuperarCuenta()
        {
            WeakReferenceMessenger.Default.Send(new CambiarVistaMessage("RecuperarCuenta"));
        }
    }
}