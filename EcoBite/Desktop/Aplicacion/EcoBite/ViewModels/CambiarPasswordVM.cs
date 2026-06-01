using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using EcoBite.Services;
using System.Windows;

namespace EcoBite.ViewModels
{
    public partial class CambiarPasswordVM : ObservableObject
    {

        [ObservableProperty]
        private string nuevaPassword;

        [ObservableProperty]
        private string confirmarPassword;

        [RelayCommand]
        private void CambiarPassword()
        {
            if (string.IsNullOrWhiteSpace(NuevaPassword) ||
                string.IsNullOrWhiteSpace(ConfirmarPassword))
            {
                MessageBox.Show("Completa todos los campos.");
                return;
            }

            if (NuevaPassword != ConfirmarPassword)
            {
                MessageBox.Show("Las contraseñas no coinciden.");
                return;
            }

            int idRestaurante = IntroducirCodigoVM.IdRestauranteRecuperacion;

            if (idRestaurante == 0)
            {
                MessageBox.Show("Error: restaurante no identificado.");
                return;
            }

            bool ok = ApiRestService.UpdatePassword(idRestaurante, NuevaPassword);

            if (ok)
            {
                MessageBox.Show("Contraseña cambiada correctamente.");

                WeakReferenceMessenger.Default.Send(
                    new CambiarVistaMessage("INICIO"));
            }
            else
            {
                MessageBox.Show("Error al cambiar la contraseña.");
            }
        }

        [RelayCommand]
        private void Volver()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("INTRODUCIR_CODIGO"));
        }
    }
}