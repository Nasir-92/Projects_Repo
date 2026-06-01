using Microsoft.Win32;
using System;
using System.IO;

//para convertir archivo → Base64

namespace EcoBite.Helpers
{
    public static class ImageHelper
    {
        public static string PickImageAsBase64()
        {
            var dlg = new OpenFileDialog
            {
                Title = "Selecciona una imagen",
                Filter = "Imágenes|*.jpg;*.jpeg;*.png;*.webp;*.bmp",
                Multiselect = false
            };

            if (dlg.ShowDialog() != true)
                return null;

            byte[] bytes = File.ReadAllBytes(dlg.FileName);
            return Convert.ToBase64String(bytes);
        }
    }
}