package view.dialogs.configTextFieldView;

import javax.swing.JTextField;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class ConfigLimitedTextField extends JTextField {
    public ConfigLimitedTextField(int limit) {
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (doc.getLength() + string.length() <= limit) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (doc.getLength() - length + text.length() <= limit) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        this.setDocument(doc);
    }
}
