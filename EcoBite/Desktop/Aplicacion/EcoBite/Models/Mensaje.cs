using CommunityToolkit.Mvvm.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EcoBite.Models
{
    public partial class Mensaje : ObservableObject
    {
        [ObservableProperty]
        private int _idMensaje;

        [ObservableProperty]
        private int _idRemitente;

        [ObservableProperty]
        private string _contenido;

        [ObservableProperty]
        private DateTime _fechaEnvio;
    }
}