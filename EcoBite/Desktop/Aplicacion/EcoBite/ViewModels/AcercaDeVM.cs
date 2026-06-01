using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using CommunityToolkit.Mvvm.Messaging;
using EcoBite.Messages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EcoBite.ViewModels
{
    internal partial class AcercaDeVM : ObservableObject
    {
        [RelayCommand]
        private void IrAPrincipal()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("PRINCIPAL")
            );
        }

        [RelayCommand]
        private void IrAConfiguracion()
        {
            WeakReferenceMessenger.Default.Send(
                new CambiarVistaMessage("CONFIGURACION")
            );
        }
    }

}
