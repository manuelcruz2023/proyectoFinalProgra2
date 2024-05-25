import interfaces.Contract;
import models.ManagerModel;
import presenter.Presenter;
import view.main.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        Contract.Model model = new ManagerModel();
        Contract.Presenter presenter = new Presenter();
        Contract.View view = new MainView();
        model.setPresenter(presenter);
        view.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
        view.begin();
    }
}
