using CommunityToolkit.Mvvm.ComponentModel;
using Newtonsoft.Json;
using System.Collections.ObjectModel;
using System.Runtime.Serialization;

namespace EcoBite.Models
{
    [DataContract]
    public partial class Restaurante : ObservableObject
    {
        [ObservableProperty]
        [JsonProperty("idRestaurante")]
        [DataMember]
        private int _idRestaurante;

        [ObservableProperty]
        [JsonProperty("nombre")]
        [DataMember]
        private string _nombre;

        [ObservableProperty]
        [JsonProperty("email")]
        [DataMember]
        private string _email;

        [ObservableProperty]
        [JsonProperty("telefono")]
        [DataMember]
        private string _telefono;

        [ObservableProperty]
        [JsonProperty("password")]
        [DataMember]
        private string _password;

        [ObservableProperty]
        [JsonProperty("ubicacion")]
        [DataMember]
        private string _ubicacion;

        [ObservableProperty]
        [JsonProperty("horario")]
        [DataMember]
        private string _horario;

        [ObservableProperty]
        [JsonProperty("descripcion")]
        [DataMember]
        private string _descripcion;

        [ObservableProperty]
        [JsonProperty("imagen")]
        [DataMember]
        private string _imagen;

        [ObservableProperty]
        private ObservableCollection<Receta> _recetas = new();
    }
}