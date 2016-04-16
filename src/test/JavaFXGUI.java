package test;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXGUI extends Application {
	
	/*driver for application*/
	public static void main(String[] args){
		launch(args);
	}
	
	/*start method
	 * contains all methods and objects for visual components
	 * buttons and what-not
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		Button btn = new Button("click me");
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event){
				System.out.println("hello World");
			}
		});
		StackPane root =  new StackPane();
		//some object inheritance here, creates button
		root.getChildren().add(btn);
		//window size
		Scene scene = new Scene(root,500,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
