using CommunityToolkit.Mvvm.ComponentModel;
using Newtonsoft.Json;
using System.Runtime.Serialization;

namespace EcoBite.Models
{
    [DataContract]
    public partial class Receta : ObservableObject
    {
        [ObservableProperty]
        [JsonProperty("idReceta")]
        [DataMember]
        private int _idReceta;

        [ObservableProperty]
        [JsonProperty("nombre")]
        [DataMember]
        private string _nombre;

        [ObservableProperty]
        [JsonProperty("descripcion")]
        [DataMember]
        private string _descripcion;

        [ObservableProperty]
        [JsonProperty("pasos")]
        [DataMember]
        private string _pasos;

        [ObservableProperty]
        [JsonProperty("imagen")]
        [DataMember]
        private string _imagen;

        [ObservableProperty]
        [JsonProperty("idRestaurante")]
        [DataMember]
        private int _idRestaurante;
    }
}