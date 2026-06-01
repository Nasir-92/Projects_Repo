using CommunityToolkit.Mvvm.ComponentModel;
using Newtonsoft.Json;

namespace EcoBite.Models
{
    /// <summary>
    /// Clase necesaria para cuando recibamos el JSON del Post para login ese resultado se convierte
    /// en este objeto para poder manejar los datos 
    /// </summary>
    public partial class AuthUser : ObservableObject
    {
        [ObservableProperty]
        [JsonProperty("idAdmin")]
        private int? _idAdmin;

        [ObservableProperty]
        [JsonProperty("idRestaurante")]
        private int? _idRestaurante;

        [ObservableProperty]
        [JsonProperty("nombre")]
        private string _nombre;

        [ObservableProperty]
        [JsonProperty("email")]
        private string _email;

        [ObservableProperty]
        [JsonProperty("rol")]
        private string _rol;
    }
}