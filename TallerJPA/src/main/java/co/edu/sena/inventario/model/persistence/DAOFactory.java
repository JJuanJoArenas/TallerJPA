/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

/**
 *
 * @author Aprendiz
 */
public class DAOFactory {
    private static IArticleDAO articledao = new ArticleDAO();
    private static ICategoryDAO categorydao = new CategoryDAO();
    private static IEntryDAO entrydao = new EntryDAO();
    private static IExitDAO exitdao = new ExitDAO();
    private static IPersonDAO persondao = new PersonDAO();
    private static IPresentationDAO presentationdao = new PresentationDAO();
    private static ISupplierDAO supplierdao = new SupplierDAO();
    private static IUnitDAO unitdao = new UnitDAO();

    public static IArticleDAO getArticledao() {
        return articledao;
    }

    public static ICategoryDAO getCategorydao() {
        return categorydao;
    }

    public static IEntryDAO getEntrydao() {
        return entrydao;
    }

    public static IExitDAO getExitdao() {
        return exitdao;
    }

    public static IPersonDAO getPersondao() {
        return persondao;
    }

    public static IPresentationDAO getPresentationdao() {
        return presentationdao;
    }

    public static ISupplierDAO getSupplierdao() {
        return supplierdao;
    }

    public static IUnitDAO getUnitdao() {
        return unitdao;
    }
    
    
}
