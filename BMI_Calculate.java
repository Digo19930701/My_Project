package bmi_HomeWork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BMI_Calculate extends JFrame {
	private JTextField heightField;
    private JTextField weightField;
    private JTextField age;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JLabel recommendationLabel;
    private JComboBox menu;
    private JComboBox gender;
    
    

    public BMI_Calculate() {//版面按鈕輸入設定
        super("您的減脂小幫手");//左上文字標籤
        
        

        heightField = new JTextField();;//創建一個身高輸入元件
        weightField = new JTextField();//創建一個體重輸入元件
        age = new JTextField(10);//創建一個體重輸入元件
        calculateButton = new JButton("計算");//創建一個鍵算的按鈕
        //resultLabel = new JLabel();
        //recommendationLabel = new JLabel();
        String[] menu2 = new String[] {"抱歉我寧可躺著","運動1~3次","運動3~5次","運動6~7次(休息是什麼?)","我愛運動運動愛我(每天兩練)"};//定義Menu2
        String[] gender2 = new String[] {"男","女"};
        menu = new JComboBox(menu2);//Menu3裡面塞了JCBOX元件
        gender = new JComboBox(gender2);
        
        
        JPanel inputPanel = new JPanel();//新增版面
        inputPanel.setLayout(new GridLayout(6, 2));//設定顯示版面
        inputPanel.add(new JLabel("性別: "));
        inputPanel.add(gender);
        inputPanel.add(new JLabel("年齡: "));
        inputPanel.add(age);
        inputPanel.add(new JLabel("身高(cm): "));//增加身高(cm):標籤
        inputPanel.add(heightField);//設定輸入值第19行
        inputPanel.add(new JLabel("體重(kg): "));//增加體重(kg)標籤
        inputPanel.add(weightField);//設定輸入值第20行
        inputPanel.add(new JLabel("一周運動次數: "));//增加一周運動次數標籤
        inputPanel.add(menu);//增加下拉式選單裡面塞Menu2的陣列
   
        JPanel buttonPanel = new JPanel();//設定按鈕版面
        buttonPanel.add(calculateButton);//加入"計算"按鈕第21列

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);//設定27inputPanel版面在CENTER=中間
        add(buttonPanel, BorderLayout.SOUTH);//設定按鈕在下SOUTH南方
        //add(resultLabel, BorderLayout.NORTH);//將結果
       // add(recommendationLabel, BorderLayout.WEST);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        //setSize(400, 300);//設置版面大小
        setBounds(500, 250,400, 300);//顯示位置X Y以及視窗大小
        setVisible(true);//是否顯示
        setDefaultCloseOperation(EXIT_ON_CLOSE);//關閉後結束執行
        
    }

    private void calculateBMI() {
    	
    	
    	
        String heightText = heightField.getText();//將輸入字串放置heightText變數裡
        String weightText = weightField.getText();//將輸入字串放置weightText變數裡
        String age1 = age.getText();
        
       

        try {
        	double height = Double.parseDouble(heightText);//把身高字串轉換成Doble
            double weight = Double.parseDouble(weightText);//把體重字串轉換成Doble
            double age2 = Double.parseDouble(age1);//把年齡字串轉換成Doble
            double bmi = weight / ((height / 100) * (height / 100));//BMi計算
            int gender4 = gender.getSelectedIndex();//獲取性別
        	int sports = menu.getSelectedIndex();//獲取運動次數
        	double bmrboy = 5+(13.7*weight)+(5*height)-(6.8*age2);
        	double bmrgirl =655+(9.6*weight)+(1.8*height)-(4.7*age2);
        	
            
//            String result = String.format("BMI: %.2f", bmi);
//            resultLabel.setText(result);//左上角BMI計算值\
        	
        	//gender4(性別) =0等於男  gender4 =1等於女
        	//sports(運動次數)
        	
        	//太瘦男 判斷
        	if(height >0 && height <300 && weight >0  && weight <650 && age2 >0  && age2 <120  && bmi>5 && bmi<100 ) {
            if (bmi<18.5 && gender4 ==0 && sports==0  ) {
            	JOptionPane.showInternalMessageDialog
            	(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==0 && sports==1){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,但~至少有在動,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==0 && sports==2){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,有運動習慣讚啦!!但,還是建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==0 && sports==3){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,休息對您來說是奢侈品小弟我佩服,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==0 && sports==4){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,休息對您來說是奢侈品小弟我先跪,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}
    		
          //太瘦女 判斷
    		else if(bmi<18.5 && gender4 ==1 && sports==0){
    			JOptionPane.showInternalMessageDialog
            	(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==1 && sports==1){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,但~至少有在動,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==1 && sports==2){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,有運動習慣讚啦!!但,還是建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==1 && sports==3){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,休息對您來說是奢侈品小弟我佩服,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(bmi<18.5 && gender4 ==1 && sports==4){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,休息對您來說是奢侈品小弟我先跪,建議多吃點\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 2)+"~"+(weight * 3) +
            			" 克\n碳水= " + (weight * 2) +"~"+ (weight * 3) + " 克\n脂肪= " + (weight * 1)+"~"+ (weight * 1.5) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}
            
            //標準男 判斷
            else if(18.5<= bmi&& bmi <24 && gender4 ==0 && sports==0){
            	JOptionPane.showInternalMessageDialog
            	(null,String.format("BMI= %.1f", bmi)+"\n很標準喔~BOY,但建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
		    }else if(18.5<= bmi&& bmi <24 && gender4 ==0 && sports==1){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n很標準喔~BOY,至少有在動,\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(18.5<= bmi&& bmi <24 && gender4 ==0 && sports==2){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,有運動習慣讚啦!!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(18.5<= bmi&& bmi <24 && gender4 ==0 && sports==3){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,休息對您來說是奢侈品小弟我佩服\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(18.5<= bmi&& bmi <24 && gender4 ==0 && sports==4){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽BOY,休息對您來說是奢侈品小弟我先跪\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}
            
            //標準女 判斷
    		else if(18.5<= bmi&& bmi <24 && gender4 ==1 && sports==0){
            	JOptionPane.showInternalMessageDialog
            	(null,String.format("BMI= %.1f", bmi)+"\n很標準喔~Girl,但建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
		    }else if(18.5<= bmi&& bmi <24 && gender4 ==1 && sports==1){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n很標準喔~Girl,至少有在動,\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(18.5<= bmi&& bmi <24 && gender4 ==1 && sports==2){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,有運動習慣讚啦!!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(18.5<= bmi&& bmi <24 && gender4 ==1 && sports==3){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,休息對您來說是奢侈品小弟我佩服\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(18.5<= bmi&& bmi <24 && gender4 ==1 && sports==4){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太瘦喽Girl,休息對您來說是奢侈品小弟我先跪\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 2) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 2) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}
            
          //微胖男 判斷
    		 else if(24<= bmi&& bmi <27 && gender4 ==0 && sports==0){
             	JOptionPane.showInternalMessageDialog
             	(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦BOY,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
 		    }else if(24<= bmi&& bmi <27 && gender4 ==0 && sports==1){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦BOY,但至少有在動,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}else if(24<= bmi&& bmi <27 && gender4 ==0 && sports==2){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦BOY,有運動習慣讚啦!!但,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}else if(24<= bmi&& bmi <27 && gender4 ==0 && sports==3){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦BOY,休息對您來說是奢侈品小弟我佩服,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}else if(24<= bmi&& bmi <27 && gender4 ==0 && sports==4){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦BOY,休息對您來說是奢侈品小弟我先跪,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}
            
          //微胖女 判斷
     		 else if(24<= bmi&& bmi <27 && gender4 ==1 && sports==0){
              	JOptionPane.showInternalMessageDialog
              	(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦Girl,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
              			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
  		    }else if(24<= bmi&& bmi <27 && gender4 ==1 && sports==1){
      			JOptionPane.showInternalMessageDialog
      			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦Girl,但至少有在動,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
              			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
      		}else if(24<= bmi&& bmi <27 && gender4 ==2 && sports==2){
      			JOptionPane.showInternalMessageDialog
      			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦Girl,有運動習慣讚啦!!但,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
              			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
      		}else if(24<= bmi&& bmi <27 && gender4 ==3 && sports==3){
      			JOptionPane.showInternalMessageDialog
      			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦Girl,休息對您來說是奢侈品小弟我佩服,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
              			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
      		}else if(24<= bmi&& bmi <27 && gender4 ==4 && sports==4){
      			JOptionPane.showInternalMessageDialog
      			(null,String.format("BMI= %.1f", bmi)+"\n有點胖呦Girl,休息對您來說是奢侈品小弟我先跪,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
              			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
      		}
            
          //很胖男 判斷
      		else if(27<= bmi && bmi <30 && gender4 ==0 && sports==0){
      			JOptionPane.showInternalMessageDialog
            	(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦BOY,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
		    }else if(27<= bmi && bmi <30 && gender4 ==0 && sports==1){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦BOY,但至少有在動,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(27<= bmi && bmi <30 && gender4 ==0 && sports==2){
    			System.out.println("OK");
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦BOY,有運動習慣讚啦!!但,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(27<= bmi && bmi <30 && gender4 ==0 && sports==3){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦BOY,休息對您來說是奢侈品小弟我佩服,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}else if(27<= bmi && bmi <30 && gender4 ==0 && sports==4){
    			JOptionPane.showInternalMessageDialog
    			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦BOY,休息對您來說是奢侈品小弟我先跪,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
            			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		}
           
         //很胖女 判斷
    		 else if(27<= bmi && bmi <30 && gender4 ==1 && sports==0){
             	JOptionPane.showInternalMessageDialog
             	(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦Girl,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
 		    }else if(27<= bmi && bmi <30 && gender4 ==1 && sports==1){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦Girl,但至少有在動,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}else if(27<= bmi && bmi <30 && gender4 ==2 && sports==2){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦Girl,有運動習慣讚啦!!但,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}else if(27<= bmi && bmi <30 && gender4 ==3 && sports==3){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦Girl,休息對您來說是奢侈品小弟我佩服,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}else if(27<= bmi && bmi <30 && gender4 ==4 && sports==4){
     			JOptionPane.showInternalMessageDialog
     			(null,String.format("BMI= %.1f", bmi)+"\n太胖了呦Girl,休息對您來說是奢侈品小弟我先跪,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
             			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
     		}
            
            //中度肥胖男 判斷
      		 else if(30<= bmi&& bmi <35 && gender4 ==0 && sports==0){
               	JOptionPane.showInternalMessageDialog
               	(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了BOY,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
               			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
   		    }else if(30<= bmi&& bmi <35 && gender4 ==0 && sports==1){
       			JOptionPane.showInternalMessageDialog
       			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了BOY,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
               			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
       		}else if(30<= bmi&& bmi <35 && gender4 ==0 && sports==2){
       			JOptionPane.showInternalMessageDialog
       			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了BOY!!建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
               			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
       		}else if(30<= bmi&& bmi <35 && gender4 ==0 && sports==3){
       			JOptionPane.showInternalMessageDialog
       			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了BOY,休息對您來說是奢侈品小弟我佩服,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
               			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
       		}else if(30<= bmi&& bmi <35 && gender4 ==0 && sports==4){
       			JOptionPane.showInternalMessageDialog
       			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了BOY,休息對您來說是奢侈品小弟我先跪,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
               			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
       		}
              
            //中度肥胖女 判斷
       		 else if(30<= bmi&& bmi <35 && gender4 ==1 && sports==0){
                	JOptionPane.showInternalMessageDialog
                	(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了Girl,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
    		    }else if(30<= bmi&& bmi <35 && gender4 ==1 && sports==1){
        			JOptionPane.showInternalMessageDialog
        			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了Girl,但至少有在動,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
        		}else if(30<= bmi&& bmi <35 && gender4 ==2 && sports==2){
        			JOptionPane.showInternalMessageDialog
        			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了Girl,有運動習慣讚啦!!但,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
        		}else if(30<= bmi&& bmi <35 && gender4 ==3 && sports==3){
        			JOptionPane.showInternalMessageDialog
        			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了Girl,休息對您來說是奢侈品小弟我佩服,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
        		}else if(30<= bmi&& bmi <35 && gender4 ==4 && sports==4){
        			JOptionPane.showInternalMessageDialog
        			(null,String.format("BMI= %.1f", bmi)+"\n要把你擺在神壇上祭拜了Girl,休息對您來說是奢侈品小弟我先跪,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
        		}
            
            
            
            //重度肥胖男 判斷
         		 else if(bmi >=35 && gender4 ==0 && sports==0){
                  	JOptionPane.showInternalMessageDialog
                  	(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你BOY,太胖了拉!!!!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                  			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
      		    }else if(bmi >=35 && gender4 ==0 && sports==1){
          			JOptionPane.showInternalMessageDialog
          			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你BOY,太胖了拉!!!!,但至少有在動\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                  			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
          		}else if(bmi >=35 && gender4 ==0 && sports==2){
          			JOptionPane.showInternalMessageDialog
          			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你BOY,太胖了拉!!!!!有運動,你只是飲食方式不對\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                  			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
          		}else if(bmi >=35 && gender4 ==0 && sports==3){
          			JOptionPane.showInternalMessageDialog
          			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你BOY,太胖了拉!!!!!有運動,你只是飲食方式不對\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                  			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
          		}else if(bmi >=35 && gender4 ==0 && sports==4){
          			JOptionPane.showInternalMessageDialog
          			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你BOY,太胖了拉!!!!!有運動,你只是飲食方式不對\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrboy*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                  			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
          		}
                 
               //重度肥胖女 判斷
          		 else if(bmi >=35 && gender4 ==1 && sports==0){
                   	JOptionPane.showInternalMessageDialog
                   	(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你Girl,太胖了拉!!!!,建議多運動啦!\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.2))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                   			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
       		    }else if(bmi >=35 && gender4 ==1 && sports==1){
           			JOptionPane.showInternalMessageDialog
           			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你Girl,太胖了拉!!!!,但至少有在動,建議調整飲食方式\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.375))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                   			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
           		}else if(bmi >=35 && gender4 ==2 && sports==2){
           			JOptionPane.showInternalMessageDialog
           			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你Girl,太胖了拉!!!!有運動,妳只是飲食方式不對\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.55))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                   			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
           		}else if(bmi >=35 && gender4 ==3 && sports==3){
           			JOptionPane.showInternalMessageDialog
           			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你Girl,太胖了拉!!!!有運動,妳只是飲食方式不對\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.725))+"卡路里(Kcal)"+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                   			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
           		}else if(bmi >=35 && gender4 ==4 && sports==4){
           			JOptionPane.showInternalMessageDialog
           			(null,String.format("BMI= %.1f", bmi)+"\n耶穌愛你Girl,太胖了拉!!!!有運動,妳只是飲食方式不對\n"+String.format("基礎代謝(TDEE)= %.1f", (bmrgirl*1.9))+ "\n以下是建議攝取量\n蛋白質="+(weight * 1)+"~"+(weight * 1.5) +
                   			" 克\n碳水= " + (weight * 1) +"~"+ (weight * 1.5) + " 克\n脂肪= " + (weight * 0.8)+"~"+ (weight * 1) + " 克\n飲水量="+(weight*30)+"CC以上\n\n開發者Digo\nInstaGram = showyouwant_digo\n關心您的身體^_^");
           		}
            
            
            
            
    		
        }else {
        	JOptionPane.showInternalMessageDialog
   			(null,"小壞蛋以為我沒有防呆嗎?給我好好填!!!");        	
        }
        	}catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "不要鬧喔");
        	
            
            
//            	if (height>=250  ) {
//            	JOptionPane.showInternalMessageDialog
//            	(null,String.format("身高= %", height)+"??在跟我鬧!???");
//            	}else if(weight >=200){
//    			JOptionPane.showInternalMessageDialog
//    			(null,String.format("體重= %",weight )+"??真的是這樣身為作者的我也認了,我抱歉");
//            	}else if(age2>=110){
//    			JOptionPane.showInternalMessageDialog
//    			(null,String.format("年齡= %", age2)+"??真的是這樣身為作者的我也認了,我抱歉");
    		}
        
        }
    
    
    
 
    public static void main(String[] args) {
        new BMI_Calculate();
    }
}
