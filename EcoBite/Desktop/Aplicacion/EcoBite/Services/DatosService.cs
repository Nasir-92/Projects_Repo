using EcoBite.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EcoBite.Services
{
   /* public class DatosService
    {
        // Lista mock de usuarios (simula una BD)
        private List<Usuario> usuarios;

        public ObservableCollection<Restaurante> Restaurantes;

        public ObservableCollection<Receta> Recetas;

        public DatosService()
        {
            // Datos simulados
            usuarios = new List<Usuario>
            {
                new Usuario
                {
                    IdUsuario = 1,
                    Nombre = "Admin",
                    Apellidos = "EcoBite",
                    Telefono = "600000000",
                    Email = "admin@ecobite.com",
                    Password = "1234",
                    Rol = "ADMIN"
                },
                new Usuario
                {
                    IdUsuario = 2,
                    Nombre = "Usuario",
                    Apellidos = "Normal",
                    Telefono = "611111111",
                    Email = "user@ecobite.com",
                    Password = "1234",
                    Rol = "USER"
                }
            };

            Restaurantes = new ObservableCollection<Restaurante>
        {
            new Restaurante
            {
                IdRestaurante = 1,
                Nombre = "Green Garden",
                Descripcion = "Cocina saludable",
                Imagen = "/Assets/restaurante.jpg"
            },
            new Restaurante
            {
                IdRestaurante = 2,
                Nombre = "EcoFood",
                Descripcion = "Vegano",
                Imagen = "/Assets/restaurante2.jpg"
            }
        };

            Recetas = new ObservableCollection<Receta>
        {
            new Receta
            {
                IdReceta = 1,
                Nombre = "Ensalada Verde",
                Imagen = "/Assets/receta.jpg",
                IdRestaurante = 1,
                Descripcion = "Rica ensalada mediterránea"
            },
            new Receta
            {
                IdReceta = 2,
                Nombre = "Bowl Vegano",
                Imagen = "/Assets/receta2.jpg",
                IdRestaurante = 2,
                Descripcion = "Comida vegana de alta calidad"
            }
        };


            // 🔗 Asociamos las recetas a su restaurante correspondiente.
            // Recorremos cada restaurante y le asignamos SOLO las recetas
            // cuyo IdRestaurante coincide con el Id del restaurante.
            // Así cada restaurante tiene su propia lista de recetas y
            // evitamos valores null al navegar por la aplicación.
            foreach (var restaurante in Restaurantes)
            {
                restaurante.Recetas = new ObservableCollection<Receta>(
                    Recetas.Where(r => r.IdRestaurante == restaurante.IdRestaurante)
                );
            }


        }

        // Método de login REAL (busca en la lista)
        public Usuario Login(string email, string password)
        {
            return usuarios.FirstOrDefault(u =>
                u.Email == email && u.Password == password);
        }

        //Método usado para crear cuenta
        public void AddUsuario(Usuario nuevoUsuario)
        {
            // Simulamos un ID autoincremental
            nuevoUsuario.IdUsuario = usuarios.Max(u => u.IdUsuario) + 1;

            usuarios.Add(nuevoUsuario);
        }
    }*/
}