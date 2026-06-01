using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Net;
using System.Net.Mail;

namespace EcoBite.Services
{
    public static class EmailService
    {

        public static void EnviarCodigo(string destinatario, string codigo)
        {

            MailMessage mail = new MailMessage();

            mail.From = new MailAddress("biteeco51@gmail.com");
            mail.To.Add(destinatario);

            mail.Subject = "Recuperación de contraseña - EcoBite";

            mail.Body = $"Tu código de recuperación es: {codigo}";

            SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);

            smtp.Credentials = new NetworkCredential(
                "biteeco51@gmail.com",
                "kagz ydvv cdmd ijuy"
            );

            smtp.EnableSsl = true;

            smtp.Send(mail);

        }
    }
}
