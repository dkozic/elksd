package org.elksd.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import org.apache.log4j.Logger;
import org.elksd.util.PreferencesUtil;

public class OptionsDialog extends JDialog {

	private static Logger log = Logger.getLogger(OptionsDialog.class);

	private final JPanel contentPanel = new JPanel();
	private JTextField lkFolderTxt;
	private JTextField sdFolderTxt;
	private JLabel lkFolderLbl;
	private JLabel sdFolderLbl;
	private JButton sdFolderBtn;
	private JButton lkFolderBtn;
	private PreferencesUtil preferences = new PreferencesUtil();;
	private static JFileChooser fileChooser;

	/**
	 * Create the dialog.
	 */
	public OptionsDialog() {
		setTitle(Messages.getString("OptionsDialog.title"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		lkFolderLbl = new JLabel(Messages.getString("OptionsDialog.lkFolderLbl.text"));
		lkFolderLbl.setBounds(30, 25, 80, 20);
		contentPanel.add(lkFolderLbl);

		sdFolderLbl = new JLabel(Messages.getString("OptionsDialog.sdFolderLbl.text"));
		sdFolderLbl.setBounds(30, 90, 80, 20);
		contentPanel.add(sdFolderLbl);

		lkFolderTxt = new JTextField();
		lkFolderLbl.setLabelFor(lkFolderTxt);
		lkFolderTxt.setToolTipText(Messages.getString("OptionsDialog.lkFolderTxt.toolTipText"));
		lkFolderTxt.setBounds(120, 25, 200, 20);
		lkFolderTxt.setColumns(100);
		lkFolderTxt.setText(preferences.getLkFolderName());
		contentPanel.add(lkFolderTxt);

		sdFolderTxt = new JTextField();
		sdFolderLbl.setLabelFor(sdFolderTxt);
		sdFolderTxt.setToolTipText(Messages.getString("OptionsDialog.sdFolderTxt.toolTipText"));
		sdFolderTxt.setColumns(100);
		sdFolderTxt.setBounds(120, 90, 200, 20);
		sdFolderTxt.setText(preferences.getSdFolderName());
		contentPanel.add(sdFolderTxt);

		lkFolderBtn = new JButton(Messages.getString("OptionsDialog.lkFolderBtn.text")); //$NON-NLS-1$
		lkFolderBtn.setBounds(320, 25, 80, 20);
		contentPanel.add(lkFolderBtn);
		lkFolderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lkFolderChoose();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});

		sdFolderBtn = new JButton(Messages.getString("OptionsDialog.sdFolderBtn.text")); //$NON-NLS-1$
		sdFolderBtn.setBounds(320, 90, 80, 20);
		contentPanel.add(sdFolderBtn);
		sdFolderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sdFolderChoose();
				} catch (Exception ex) {
					handleException(ex);
				}
			}
		});

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							save();
						} catch (Exception ex) {
							handleException(ex);
						}
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							cancel();
						} catch (Exception ex) {
							handleException(ex);
						}
					}
				});
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private void handleException(Exception e) {
		log.error("Error in ElkFrame", e);
		JOptionPane.showMessageDialog(this, e.getMessage(), Messages.getString("OptionsDialog.exception.title"),
				JOptionPane.ERROR_MESSAGE);
	}

	private void save() {
		preferences.saveLkFolder(lkFolderTxt.getText());
		preferences.saveSdFolder(sdFolderTxt.getText());
		dispose();
	}

	private void cancel() {
		dispose();
	}

	private void sdFolderChoose() {
		JFileChooser fc = getFileChooser();
		// fc.setSelectedFile(new File (sdFolderTxt.getText()));
		fc.setCurrentDirectory(new File(sdFolderTxt.getText()));
		int returnVal = fc.showDialog(this, Messages.getString("OptionsDialog.fileChooser.title"));

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			sdFolderTxt.setText(file.getAbsolutePath());
		}
	}

	private void lkFolderChoose() {
		JFileChooser fc = getFileChooser();
		// fc.setSelectedFile(new File (lkFolderTxt.getText()));
		fc.setCurrentDirectory(new File(lkFolderTxt.getText()));
		int returnVal = fc.showDialog(this, Messages.getString("OptionsDialog.fileChooser.title"));

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			lkFolderTxt.setText(file.getAbsolutePath());
		}
	}

	public JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setMultiSelectionEnabled(false);
		}
		return fileChooser;
	}

}
