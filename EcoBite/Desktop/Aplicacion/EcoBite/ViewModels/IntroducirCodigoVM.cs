using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class IntroducirCodigoVM : ObservableObject
    {



        [ObservableProperty]
        private string codigoUsuario;

        // Código correcto generado
        public static string CodigoCorrecto;

        // Email del restaurante que recupera la cuenta
        public static string EmailRecuperacion;

        public static int IdRestauranteRecuperacion;


        [RelayCommand]
        private void VerificarCodigo()
        {
            if (CodigoUsuario == CodigoCorrecto)
            {
                WeakReferenceMessenger.Default.Send(
                    new CambiarVistaMessage("CAMBIAR_PASSWORD"));
            }
            else
            {
                MessageBox.Show("El código es incorrecto.");
            }
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("INICIO"));
        }
    }
}