using EcoBite.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace EcoBite.Views
{
    /// <summary>
    /// Lógica de interacción para Inicio.xaml
    /// </summary>
    public partial class Inicio : UserControl
    {
        public Inicio()
        {
            InitializeComponent();

            //MinWidth = SystemParameters.PrimaryScreenWidth;
            //MinHeight = SystemParameters.PrimaryScreenHeight;
        }

        //**********
        // Este método existe porque en WPF el control PasswordBox NO permite enlazar
        // directamente la contraseña con el ViewModel por motivos de seguridad.
        // 
        // Por ese motivo, cuando el usuario escribe en el PasswordBox, capturamos
        // el evento PasswordChanged y copiamos manualmente el valor escrito
        // en la propiedad Password del InicioViewModel.
        // 
        // De esta forma:
        // - La lógica de validación sigue estando en el ViewModel.
        // - No se rompe el patrón MVVM.
        // - Solo se usa el code-behind como "puente" técnico entre la vista y el ViewModel.
        private void PasswordChanged(object sender, System.Windows.RoutedEventArgs e)
        {
            if (DataContext is InicioVM vm)
                vm.Password = ((PasswordBox)sender).Password;
        }
    
    }
}
