using System.Windows.Controls;
using EcoBite.ViewModels;

namespace EcoBite.Views
{
    public partial class CrearCuenta : UserControl
    {
        public CrearCuenta()
        {
            InitializeComponent();
        }

        private void PasswordChanged(object sender, System.Windows.RoutedEventArgs e)
        {
            if (DataContext is CrearCuentaVM vm)
                vm.Password = ((PasswordBox)sender).Password;
        }

        private void ConfirmarPasswordChanged(object sender, System.Windows.RoutedEventArgs e)
        {
            if (DataContext is CrearCuentaVM vm)
                vm.ConfirmarPassword = ((PasswordBox)sender).Password;
        }
    }
}