using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Helpers;
using EcoBite.Messages;
using EcoBite.Models;
using EcoBite.Services;
using System.Linq;
using System.Text.RegularExpressions;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class RecuperarCuentaVM : ObservableObject
    {

        
        [ObservableProperty]
        private string _email;

        [ObservableProperty]
        private string _codigoGenerado;

        [RelayCommand]
        private void EnviarCodigo()
        {
            if (string.IsNullOrWhiteSpace(Email))
            {
                MessageBox.Show("Introduce tu correo electrónico.");
                return;
            }

            if (!EsEmailValido(Email))
            {
                MessageBox.Show("El formato del email no es válido.");
                return;
            }

            var restaurantes = ApiRestService.GetRestaurantes();

            Restaurante restaurante = restaurantes
                .FirstOrDefault(r => r.Email == Email);

            if (restaurante == null)
            {
                MessageBox.Show("No existe ninguna cuenta con ese correo.");
                return;
            }

            // Generar código 
            CodigoGenerado = CodigoRecuperacionHelper.GenerarCodigo();

            // Guardar datos para las siguientes pantallas
            IntroducirCodigoVM.CodigoCorrecto = CodigoGenerado;
            IntroducirCodigoVM.EmailRecuperacion = Email;
            IntroducirCodigoVM.IdRestauranteRecuperacion = restaurante.IdRestaurante;

            // Enviar email
            EmailService.EnviarCodigo(Email, CodigoGenerado);

            MessageBox.Show("Se ha enviado un código de recuperación a tu correo.");

            // Navegar a introducir código
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("INTRODUCIR_CODIGO"));
        }
        private bool EsEmailValido(string email)
        {
            return Regex.IsMatch(email,
                @"^[^@\s]+@[^@\s]+\.[^@\s]+$",
                RegexOptions.IgnoreCase);
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(new CambiarVistaMessage("INICIO"));
        }




    }
}