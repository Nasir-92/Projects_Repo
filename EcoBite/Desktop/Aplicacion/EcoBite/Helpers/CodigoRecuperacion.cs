using System;

namespace EcoBite.Helpers
{
    public static class CodigoRecuperacionHelper
    {
        public static string GenerarCodigo()
        {
            Random random = new Random();
            return random.Next(100000, 999999).ToString();
        }
    }
}