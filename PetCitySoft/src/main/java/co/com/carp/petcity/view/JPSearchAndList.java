package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import co.com.carp.petcity.entity.Owner;

public class JPSearchAndList extends Observable implements ActionListener {
	
	private JTextField jtfSearch;

	private JButton jbtSearch;
	
	private Set<Owner> ownerSet;
	
	public JPanel createSearchAndListSection(Set<Owner> ownerSet, int maxHeight) {
		this.ownerSet = ownerSet;
		JPanel jpSearchAndList = new JPanel();
		jpSearchAndList.setLayout(new BorderLayout());
		jpSearchAndList.setSize(new Dimension(250, (int) maxHeight - 80));		
		
		JPanel jpnSubPanelSearch = new JPanel(null);
		jpnSubPanelSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY));
		jpnSubPanelSearch.setPreferredSize(new Dimension(240, 65));
		jpnSubPanelSearch.setBackground(new Color(34, 139, 34));
		
		jtfSearch = new JTextField();
		jtfSearch.setBounds(5, 10, 230, 20);
		jpnSubPanelSearch.add(jtfSearch);
		jbtSearch = new JButton("BUSCAR");
		jbtSearch.setForeground(new Color(255, 255, 255));
		jbtSearch.setBounds(145, 35, 89, 23);
		jbtSearch.setBackground(new Color(30, 144, 255));
		jbtSearch.setFont(new Font("Verdana", Font.BOLD, 12));
		jbtSearch.addActionListener(this);
		jpnSubPanelSearch.add(jbtSearch);
		
		jpSearchAndList.add(jpnSubPanelSearch, BorderLayout.NORTH);		
		JPanel jpViewPort = new JPanel(null);
		jpViewPort.setBackground(Color.WHITE);
		int height = ownerSet != null ? 80 * ownerSet.size() : 80;
		jpViewPort.setPreferredSize(new Dimension(230, height));
		jpViewPort.setBackground(Color.WHITE);
		
		int yForNextSubPanel = 0;
		int cont = 0;
		if (ownerSet != null && ownerSet.size() > 0) {
			for (Owner owner : ownerSet) {
				JPanel subPanel = this.createOwnerCard(owner);
				subPanel.setBounds(0, yForNextSubPanel, 230, 80);
				yForNextSubPanel = yForNextSubPanel + 80;
	
				jpViewPort.add(subPanel);
				if (cont % 2 == 1) {
					subPanel.setBackground(Color.WHITE);
				}
				cont++;
			}
		}		
		JScrollPane jspScroll = new JScrollPane(jpViewPort, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspScroll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jspScroll.setAutoscrolls(true);		
		jpSearchAndList.add(jspScroll, BorderLayout.CENTER);
		return jpSearchAndList;
	}
	
	private JPanel createOwnerCard(Owner owner) {
		JPanel jpOwnerCard = new JPanel();
		jpOwnerCard.setLayout(null);
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);
		
		JLabel jlbOwnerIdentification = new JLabel("" + owner.getDocumentId());
		jlbOwnerIdentification.setFont(verdanaBold);
		jlbOwnerIdentification.setBounds(10, 10, 90, 20);
		jpOwnerCard.add(jlbOwnerIdentification);
		
		JLabel jlbOwnerName = new JLabel(owner.getName());
		jlbOwnerName.setFont(verdanaBold);
		jlbOwnerName.setBounds(10, 30, 160, 20);
		jpOwnerCard.add(jlbOwnerName);
		
		JButton jbtViewDetail = new JButton("Ver");
		jbtViewDetail.setName(owner.getIdentification() + "");
		jbtViewDetail.setFont(verdanaPlain);
		jbtViewDetail.setBounds(170, 50, 40, 20);
		jbtViewDetail.addActionListener(this);
		jbtViewDetail.setBackground(new Color(255, 100, 0));
		jbtViewDetail.setForeground(Color.WHITE);
		jpOwnerCard.add(jbtViewDetail);
		return jpOwnerCard;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Ver")) {
			int id = Integer.parseInt(((JButton)evt.getSource()).getName());
			for (Owner owner : ownerSet) {
				if (owner.getIdentification() == id) {
					setChanged();
					notifyObservers(owner);
					break;
				}
			}
			
		}
	}
}
