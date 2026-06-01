using EcoBite.Models;
using Newtonsoft.Json;
using RestSharp;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using static System.Net.WebRequestMethods;

namespace EcoBite.Services
{
    public static class ApiRestService
    {

        private static readonly string ENDPOINT = "http://ecobiteapirest-env-1.eba-ry4bepqu.us-east-1.elasticbeanstalk.com/api";
        // private static readonly string ENDPOINT = "http://localhost:8080/bdecobite/api/";

        // LOGIN
        public static AuthUser Login(string email, string password)
        {
            RestClient client = new RestClient(ENDPOINT);

            RestRequest request = new RestRequest("auth/login", Method.Post);

            request.AddJsonBody(new
            {
                email = email,
                password = password
            });

            RestResponse response = client.Execute(request);

            System.Diagnostics.Debug.WriteLine(response.StatusCode);
            System.Diagnostics.Debug.WriteLine(response.Content);

            if (!response.IsSuccessful)
                return null;

            return JsonConvert.DeserializeObject<AuthUser>(response.Content);
        }

        // RESTAURANTES
        public static List<Restaurante> GetRestaurantes()
        {
            RestClient client = new RestClient(ENDPOINT);
            RestRequest request = new RestRequest("restaurantes", Method.Get);

            RestResponse response = client.Execute(request);

            if (!response.IsSuccessful)
            {
                MessageBox.Show("Error al conectar con el servidor.");
                return new List<Restaurante>();
            }

            if (string.IsNullOrWhiteSpace(response.Content) || response.Content.StartsWith("<"))
            {
                MessageBox.Show("Error al obtener los restaurantes.");
                return new List<Restaurante>();
            }

            return JsonConvert.DeserializeObject<List<Restaurante>>(response.Content);
        }

        // RECETAS
        public static List<Receta> GetRecetas()
        {
            RestClient client = new RestClient(ENDPOINT);
            RestRequest request = new RestRequest("recetas", Method.Get);

            RestResponse response = client.Execute(request);

            Debug.WriteLine(response.StatusCode);
            Debug.WriteLine(response.Content);

            if (!response.IsSuccessful)
            {
                MessageBox.Show("Error al conectar con el servidor.");
                return new List<Receta>();
            }

            if (string.IsNullOrWhiteSpace(response.Content) || response.Content.StartsWith("<"))
            {
                MessageBox.Show("La API no devolvió datos válidos.");
                return new List<Receta>();
            }

            return JsonConvert.DeserializeObject<List<Receta>>(response.Content);
        }

        // RECETAS POR RESTAURANTE
        public static List<Receta> GetRecetasByRestaurante(int id)
        {
            RestClient client = new RestClient(ENDPOINT);
            RestRequest request = new RestRequest($"restaurantes/{id}/recetas", Method.Get);

            RestResponse response = client.Execute(request);

            return JsonConvert.DeserializeObject<List<Receta>>(response.Content);
        }

        // CREAR RECETA
        public static void PostReceta(Receta receta)
        {
            RestClient client = new RestClient(ENDPOINT);
            RestRequest request = new RestRequest("recetas", Method.Post);

            string data = JsonConvert.SerializeObject(receta); // Convertimos el objeto a JSON para enviarlo en el cuerpo de la solicitud.
            request.AddJsonBody(data);                                 // Agregamos el JSON al cuerpo de la solicitud.
            request.AddHeader("Content-Type", "application/json");     // Especificamos que el contenido es JSON.

            RestResponse response = client.Execute(request);

            Trace.WriteLine(response.StatusCode);   // Código 400 es error. Código 200 es éxito.
            Trace.WriteLine(response.Content);
            Trace.WriteLine(response.ErrorMessage);
        }

        // CREAR RESTAURANTE
        public static void PostRestaurante(Restaurante restaurante)
        {
            RestClient client = new RestClient(ENDPOINT);

            RestRequest request = new RestRequest("restaurantes", Method.Post);

            //request.AddJsonBody(restaurante);

            string data = JsonConvert.SerializeObject(restaurante); // Convertimos el objeto a JSON para enviarlo en el cuerpo de la solicitud.
            request.AddJsonBody(data);                                 // Agregamos el JSON al cuerpo de la solicitud.
            request.AddHeader("Content-Type", "application/json");     // Especificamos que el contenido es JSON.

            RestResponse response = client.Execute(request);

            Trace.WriteLine(response.StatusCode);   // Código 400 es error. Código 200 es éxito.
            Trace.WriteLine(response.Content);
            Trace.WriteLine(response.ErrorMessage);
        }

        // BORRAR RECETA
        public static bool DeleteReceta(int idReceta)
        {
            RestClient client = new RestClient(ENDPOINT);
            RestRequest request = new RestRequest($"recetas/{idReceta}", Method.Delete);

            RestResponse response = client.Execute(request);

            System.Diagnostics.Debug.WriteLine(response.StatusCode);
            System.Diagnostics.Debug.WriteLine(response.Content);

            return response.IsSuccessful;
        }


        public static bool UpdatePassword(int idRestaurante, string nuevaPassword)
        {
            RestClient client = new RestClient(ENDPOINT);

            RestRequest request = new RestRequest($"restaurantes/{idRestaurante}/password", Method.Put);

            request.AddHeader("Content-Type", "application/json");

            request.AddJsonBody(new
            {
                password = nuevaPassword
            });

            RestResponse response = client.Execute(request);

            Debug.WriteLine("STATUS: " + response.StatusCode);
            Debug.WriteLine("CONTENT: " + response.Content);
            Debug.WriteLine("ERROR: " + response.ErrorMessage);

            if (response.StatusCode == System.Net.HttpStatusCode.OK)
                return true;

            MessageBox.Show($"Error API:\n{response.Content}");
            return false;
        }
        public static bool UpdateConfiguration(int idRestaurante, Restaurante restaurante)
        {
            RestClient client = new RestClient(ENDPOINT);

            RestRequest request = new RestRequest($"restaurantes/{idRestaurante}/configuration", Method.Put);

            request.AddHeader("Content-Type", "application/json");

            request.AddJsonBody(new
            {
                nombre = restaurante.Nombre,
                password = restaurante.Password,
                email = restaurante.Email,
                descripcion = restaurante.Descripcion,
                telefono = restaurante.Telefono,
                ubicacion = restaurante.Ubicacion,
                horario = restaurante.Horario,
                imagen = restaurante.Imagen
            });

            RestResponse response = client.Execute(request);

            Debug.WriteLine("STATUS: " + response.StatusCode);
            Debug.WriteLine("CONTENT: " + response.Content);
            Debug.WriteLine("ERROR: " + response.ErrorMessage);

            if (response.StatusCode == System.Net.HttpStatusCode.OK ||
                response.StatusCode == System.Net.HttpStatusCode.NoContent)
                return true;

            MessageBox.Show($"Error API:\n{response.Content}");
            return false;
        }
    }
}