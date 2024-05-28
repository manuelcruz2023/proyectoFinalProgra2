package view.dialogs.configTextFieldView;

import javax.swing.JTextField;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class ConfigTextFieldNumber extends JTextField {
    public ConfigTextFieldNumber() {
        ((AbstractDocument) getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                    AttributeSet attrs)
                    throws BadLocationException {
                if (text != null && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
}