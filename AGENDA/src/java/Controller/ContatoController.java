package Controller;
import Bean.Contato;
import DAO.ContatoDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class ContatoController implements Serializable {
    private Contato contatoB;
    private DataModel listaContatos;
    
    public ContatoController(){
        contatoB = new Contato();
    }

    public Contato getContatoB() {
        return contatoB;
    }

    public void setContatoB(Contato contatoB) {
        this.contatoB = contatoB;
    }

    public DataModel getListaContatos() {
        ContatoDAO dao = new ContatoDAO();
        listaContatos = new ListDataModel(dao.listarContato());
        return listaContatos;
    }

    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    
    public void novoContato(){
        contatoB = new Contato();
    
    }
    
    public void selecionarContato(){
       contatoB = (Contato)listaContatos.getRowData();
    }
    
    public String salvarContato(){
       ContatoDAO dao = new ContatoDAO();
       if(dao.salvarContato(contatoB)){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CADASTRADO COM SUCESSO!!", ""));
           return "listarcontatos";
    }
    
        return "erro";
    
  }
     public String editarContato(){
       ContatoDAO dao = new ContatoDAO();
       if(dao.editarContato(contatoB)){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO COM SUCESSO!!", ""));
           return "listarcontatos";
    }
    
        return "erro";
    
    }
     
      public String excluirContato(){
       ContatoDAO dao = new ContatoDAO();
       if(dao.excluirContato(contatoB)){
           FacesContext contexto = FacesContext.getCurrentInstance();
           contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXCLUIDO COM SUCESSO!!", ""));
           return "listarcontatos";
    }
    
        return "erro";
    
    }
      
      
}

