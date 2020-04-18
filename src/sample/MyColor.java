package sample;

import javafx.scene.paint.Color;

public enum MyColor {
    BLUE ,
    YELLOW,
    GREY ,
    PINK ,
    WHITE ,
    ORANGE ,
    PURPLE,
    BLACK;

    Color color;

    MyColor()
    {
        switch(this.ordinal())
        {
            case 0:
                this.color = Color.BLUE;
                break;
            case 1:
                this.color = Color.YELLOW;
                break;
            case 2:
                this.color = Color.GREY;
                break;
            case 3:
                this.color = Color.PINK;
                break;
            case 4:
                this.color = Color.WHITE;
                break;
            case 5:
                this.color = Color.ORANGE;
                break;
            case 6:
                this.color = Color.PURPLE;
                break;
            case 7:
                this.color = Color.BLACK;
                break;
            default:
                this.color = null;
        }
    }

    Color getColor()
    {
        return color;
    }



}
