using CommunityToolkit.Mvvm.Messaging.Messages;
using EcoBite.Models;

namespace EcoBite.Messages
{
    // DIFUSIÓN: pedir cambio de vista
    public class CambiarVistaMessage : ValueChangedMessage<string>
    {
        public CambiarVistaMessage(string vista) : base(vista)
        {
        }
    }

    public class UsuarioLogueadoMessage : ValueChangedMessage<AuthUser>
    {
        public UsuarioLogueadoMessage(AuthUser usuario) : base(usuario)
        {
        }
    }
    public class IdRestauranteMessage : ValueChangedMessage<int>
    {
        public IdRestauranteMessage(int id) : base(id)
        {
        }
    }

    // Navegar a detalle de restaurante
    public class NavegarARestauranteMessage : ValueChangedMessage<Restaurante>
    {
        public NavegarARestauranteMessage(Restaurante restaurante)
            : base(restaurante) { }
    }

    // Navegar a detalle de receta
    public class NavegarARecetaMessage : ValueChangedMessage<Receta>
    {
        public NavegarARecetaMessage(Receta receta)
            : base(receta) { }
    }

    // Mensaje simple para volver a Principal
    public class VolverAPrincipalMessage : ValueChangedMessage<bool>
    {
        public VolverAPrincipalMessage() : base(true) { }
    }

    // Navegar a la vista AcercaDe
    public class NavegarAAcercaDeMessage : ValueChangedMessage<bool>
    {
        public NavegarAAcercaDeMessage() : base(true) { }
    }

    public class RecetasActualizadasMessage : ValueChangedMessage<bool>
    {
        public RecetasActualizadasMessage() : base(true)
        {
        }
    }


}

