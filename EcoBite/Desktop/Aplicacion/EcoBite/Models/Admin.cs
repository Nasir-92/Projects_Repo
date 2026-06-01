using CommunityToolkit.Mvvm.ComponentModel;
using Newtonsoft.Json;
using System.Runtime.Serialization;

namespace EcoBite.Models
{
    [DataContract]
    public partial class Admin : ObservableObject
    {
        [ObservableProperty]
        [JsonProperty("idAdmin")]
        [DataMember]
        private int _idAdmin;

        [ObservableProperty]
        [JsonProperty("nombre")]
        [DataMember]
        private string _nombre;

        [ObservableProperty]
        [JsonProperty("email")]
        [DataMember]
        private string _email;

        [ObservableProperty]
        [JsonProperty("password")]
        [DataMember]
        private string _password;

        [ObservableProperty]
        [JsonProperty("createdAt")]
        [DataMember]
        private string _createdAt;
    }
}