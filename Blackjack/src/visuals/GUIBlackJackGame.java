package visuals;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIBlackJackGame extends JFrame implements ActionListener{

	JButton[] butChips;
	JButton butYes, butNo;
	JLabel playerInfoLabel, croupierInfoLabel, roundInfoLabel, userChipsLabel, currentBetLabel, winnerLabel;
	
	
	public GUIBlackJackGame(String title) {
		super(title);
		   
		initComponents();
	}
	
	
	
	private void initComponents() {
		SubJPanel upContainer, downContainer, butContainer, chipsButContainer, yesNoButContainer, playerInfoContainer, croupierInfoContainer, labelContainer;
		Dimension windowDim, downContainerDim, upContainerDim, butContainerDim, chipsButContainerDim, yesNoButContainerDim, playerInfoContainerDim, croupierInfoContainerDim, labelContainerDim;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// Creating the panels
		upContainer = new SubJPanel();
		downContainer = new SubJPanel();
		butContainer = new SubJPanel();
		chipsButContainer = new SubJPanel();
		yesNoButContainer = new SubJPanel();
		playerInfoContainer = new SubJPanel();
		croupierInfoContainer = new SubJPanel();
		labelContainer = new SubJPanel();		
		
		
		// SETTING THE LAYOUT
		
		
		// Container of JFrame
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		windowDim = new Dimension(600, 400);
		setSize( windowDim );
		setMinimumSize(windowDim);
		
		this.getContentPane().setSize(windowDim);

		// upContainer
		this.getContentPane().add(upContainer); // Add the container

		//upContainer.setLayout(new FlowLayout());
		upContainerDim = new Dimension( upContainer.getPreferredSize(1, 0.75) );
		upContainer.setSize( upContainerDim );
		upContainer.setPreferredSize( upContainerDim );
		System.out.println( upContainerDim ); // 600, 300

		
		
		// downContainer
		this.getContentPane().add(downContainer); // Add the container

		//downContainer.setLayout(new FlowLayout());
		downContainerDim = new Dimension(downContainer.getPreferredSize(1, 0.25));
		downContainer.setSize( downContainerDim );
		downContainer.setPreferredSize( downContainerDim );
		System.out.println( downContainer.getPreferredSize(1, 0.25)); // 600, 100

		
		// butContainer
		
		downContainer.add(butContainer); // Add the container

		//butContainer.setLayout( new FlowLayout() );
		butContainerDim = new Dimension(butContainer.getPreferredSize(0.75, 1));
		butContainer.setSize(butContainerDim);
		butContainer.setPreferredSize( butContainerDim );
		System.out.println( butContainerDim ); // 450, 100

		
		// playerInfoContainer
		downContainer.add(playerInfoContainer);

		//playerInfoContainer.setLayout( new FlowLayout() );
		playerInfoContainerDim = new Dimension( playerInfoContainer.getPreferredSize(0.25, 1) );
		playerInfoContainer.setSize(playerInfoContainerDim);
		playerInfoContainer.setPreferredSize( playerInfoContainerDim );
		System.out.println(playerInfoContainerDim); // 150, 100

		
		//chipsButConatienr
		butContainer.add(chipsButContainer);
		
		//chipsButContainer.setLayout( new FlowLayout() );
		chipsButContainerDim = new Dimension( chipsButContainer.getPreferredSize(0.75, 1) );
		chipsButContainer.setSize( chipsButContainerDim );
		chipsButContainer.setPreferredSize( chipsButContainerDim );
		System.out.println( chipsButContainerDim ); // 377, 100

		
		// yesNoButContainer
		butContainer.add(yesNoButContainer);

		yesNoButContainer.setLayout( new BoxLayout(yesNoButContainer, BoxLayout.Y_AXIS) );
		
		yesNoButContainerDim = new Dimension(yesNoButContainer.getPreferredSize(0.25, 1));
		yesNoButContainer.setSize(yesNoButContainerDim);
		yesNoButContainer.setPreferredSize( yesNoButContainerDim );
		System.out.println(yesNoButContainerDim); // 112, 100

		
		// labelContainer
		upContainer.add(labelContainer);

		//labelContainer.setLayout( new FlowLayout() );
		labelContainerDim = new Dimension( labelContainer.getPreferredSize(0.75, 1) );
		labelContainer.setSize(labelContainerDim);
		labelContainer.setPreferredSize( labelContainerDim );
		System.out.println( labelContainerDim ); // 450, 300

		
		// croupierInfoContainer
		upContainer.add(croupierInfoContainer);

		//croupierInfoContainer.setLayout( new FlowLayout() );
		croupierInfoContainerDim = new Dimension( croupierInfoContainer.getPreferredSize(0.25, 1) );
		croupierInfoContainer.setSize(croupierInfoContainerDim);
		croupierInfoContainer.setPreferredSize( croupierInfoContainerDim );
		System.out.println(croupierInfoContainerDim); // 150, 300

		
		// CREATING AND ADDING THE BUTTONS
		butChips = new JButton[3];
		for (int i = 0; i < butChips.length; i ++) {
			butChips[i] = new JButton( Integer.toString(i * 5));
			
			
			chipsButContainer.add(butChips[i]);
		}

		butYes = new JButton("yes");
		butNo = new JButton("no");
		
		yesNoButContainer.add(butYes);
		yesNoButContainer.add(butNo);

		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public static void main (String args[]) {

        EventQueue.invokeLater(
                new Runnable() {

                	@Override
                    public void run() {
                        JFrame frame = new GUIBlackJackGame("BlackJack!");
                        frame.setVisible(true);

                    }
                }
        );

    }
	
	
}
