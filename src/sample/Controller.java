package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.joda.time.DateTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

	@FXML private TextField price;
	@FXML private TextField price4040;
	@FXML private TextField price30;
	@FXML private TextField price40;
	@FXML private TextField price20;
	@FXML private TextField price50;
	@FXML private TextField price25;
	@FXML private TextField price60;
	@FXML private TextField lprice15;
	@FXML private TextField lm_price15;
	@FXML private TextField lprice;
	@FXML private TextField lm_price;
	@FXML private TextField pprice;
	@FXML private TextField listm2;
	@FXML private TextField y_price;
	@FXML private TextField yp_price;
	@FXML private TextField ogr;
	@FXML private TextField gips;
	@FXML private TextField vata;
	@FXML private TextField plenka;
	@FXML private TextField ot_price;
	@FXML private TextField list_mag_price;
	@FXML private TextField list_an_price;
	@FXML private TextField list_pf_price;
	@FXML private TextField m10_price;
	@FXML private TextField m16_price;
	@FXML private TextField in_price;
	@FXML private TextField pl_price;
	@FXML private TextField la_price;
	@FXML private TextField dnal_price;
	@FXML private TextField lit_nal_price;

	@FXML
	protected void encrypt(ActionEvent event) throws IOException {
		StringBuilder builder = new StringBuilder();
		readInputValues(builder);

		Encryptor encryptor = new Encryptor();
		System.out.println("--------------Original prices:--------------");
		System.out.println(builder.toString());
		String encrypedString = encryptor.encrypt(builder.toString());
		String key = encryptor.getEncryptionKey();

		DateTime current = DateTime.now();

		FileChooser fileChooser = new FileChooser();

		//Show save file dialog
		File file = fileChooser.showSaveDialog(((Node)event.getTarget()).getScene().getWindow());

		if(file != null){
			FileWriter writer = new FileWriter(file);
			writer.write(key);
			writer.write(encrypedString);
			writer.flush();
			writer.close();
		}
	}

	private void readInputValues(StringBuilder builder) {
		builder.append(price.getId() + ":" + price.getText() + ";");
		builder.append(price4040.getId() + ":" + price4040.getText() + ";");
//		builder.append(price30.getId() + ":" + price30.getText() + ";");
//		builder.append(price40.getId() + ":" + price40.getText() + ";");
//		builder.append(price20.getId() + ":" + price20.getText() + ";");
//		builder.append(price50.getId() + ":" + price50.getText() + ";");
//		builder.append(price25.getId() + ":" + price25.getText() + ";");
//		builder.append(price60.getId() + ":" + price60.getText() + ";");
//		builder.append(lprice15.getId() + ":" + lprice15.getText() + ";");
//		builder.append(lm_price15.getId() + ":" + lm_price15.getText() + ";");
//		builder.append(lprice.getId() + ":" + lprice.getText() + ";");
//		builder.append(lm_price.getId() + ":" + lm_price.getText() + ";");
//		builder.append(pprice.getId() + ":" + pprice.getText() + ";");
//		builder.append(listm2.getId() + ":" + listm2.getText() + ";");
//		builder.append(y_price.getId() + ":" + y_price.getText() + ";");
//		builder.append(yp_price.getId() + ":" + yp_price.getText() + ";");
//		builder.append(ogr.getId() + ":" + ogr.getText() + ";");
//		builder.append(gips.getId() + ":" + gips.getText() + ";");
//		builder.append(vata.getId() + ":" + vata.getText() + ";");
//		builder.append(plenka.getId() + ":" + plenka.getText() + ";");
//		builder.append(ot_price.getId() + ":" + ot_price.getText() + ";");
//		builder.append(list_mag_price.getId() + ":" + list_mag_price.getText() + ";");
//		builder.append(list_an_price.getId() + ":" + list_an_price.getText() + ";");
//		builder.append(list_pf_price.getId() + ":" + list_pf_price.getText() + ";");
//		builder.append(m10_price.getId() + ":" + m10_price.getText() + ";");
//		builder.append(m16_price.getId() + ":" + m16_price.getText() + ";");
//		builder.append(in_price.getId() + ":" + in_price.getText() + ";");
//		builder.append(pl_price.getId() + ":" + pl_price.getText() + ";");
//		builder.append(la_price.getId() + ":" + la_price.getText() + ";");
//		builder.append(dnal_price.getId() + ":" + dnal_price.getText() + ";");
//		builder.append(lit_nal_price.getId() + ":" + lit_nal_price.getText() + ";");
	}

}
