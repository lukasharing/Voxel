package net.guerra24.voxel.client.launcher;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.guerra24.voxel.client.kernel.Engine;
import net.guerra24.voxel.client.kernel.util.Logger;
import net.guerra24.voxel.client.launcher.login.LoginDialog;
import net.guerra24.voxel.client.launcher.properties.Reader;

public class Launcher {

	public static void LauncherStart() {
		ImageIcon imgicon = new ImageIcon(Reader.IconPath);
		ImageIcon imgicon1 = new ImageIcon(Reader.BackPath);

		Logger.log(ConstantsLauncher.launcherVersion);

		final JFrame frame = new JFrame("Launcher "
				+ ConstantsLauncher.gameName);
		final JButton btnLogin = new JButton("Login");
		final JButton btnExit = new JButton("Exit");
		final JButton btnOptions = new JButton("Options");

		Insets insets = frame.getInsets();
		Dimension size = btnLogin.getPreferredSize();
		btnLogin.setBounds(560 + insets.left, 630 + insets.top, size.width,
				size.height);
		size = btnExit.getPreferredSize();
		btnExit.setBounds(640 + insets.left, 630 + insets.top, size.width,
				size.height);
		size = btnOptions.getPreferredSize();
		btnOptions.setBounds(740 + insets.left, 630 + insets.top, 150,
				size.height);
		Logger.log("Launcher Started");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDlg = new LoginDialog(frame);
				loginDlg.setVisible(true);
				// if logon successfully
				if (loginDlg.isSucceeded()) {
					frame.dispose();
					Logger.log("Starting Voxel");
					Engine.StartGame();
				}
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logger.log("Launcher Closed");
				frame.dispose();
				System.exit(0);
			}

		});
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOptions.setEnabled(false);
			}

		});
		frame.setSize(1280 + insets.left + insets.right, 720 + insets.top
				+ insets.bottom);
		frame.setLayout(null);
		frame.setIconImage(imgicon.getImage());
		frame.setContentPane(new JLabel(new ImageIcon(imgicon1.getImage())));
		frame.getContentPane().add(btnLogin);
		frame.getContentPane().add(btnExit);
		frame.getContentPane().add(btnOptions);
		frame.setVisible(true);
		frame.setLocation(85, 85);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}