using EcoBite.ViewModels;
using System.Windows;
using System.Windows.Controls;

namespace EcoBite.Views
{
    public partial class CambiarPassword : UserControl
    {
        public CambiarPassword()
        {
            InitializeComponent();
        }

        private void Password1Changed(object sender, RoutedEventArgs e)
        {
            if (DataContext is CambiarPasswordVM vm)
                vm.NuevaPassword = ((PasswordBox)sender).Password;
        }

        private void Password2Changed(object sender, RoutedEventArgs e)
        {
            if (DataContext is CambiarPasswordVM vm)
                vm.ConfirmarPassword = ((PasswordBox)sender).Password;
        }
    }
}