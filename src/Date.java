
public class Date {
    private int bits;
    /*private static int mDays[] = {
            31,28,31,30,31,30,31,31,30,31,30,31
    };*/

    public Date(int Bits) throws Exception{
        setBits(Bits);
    }

    private boolean checkLeap(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidDate(int day, int month, int year) throws Exception
    {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return false; // Mes o día fuera de rangos válidos.
        }

        if (month == 2) {
            // Febrero tiene 29 días en un año bisiesto.
            if (checkLeap(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false; // Meses con 30 días.
        }

        return true; // El resto de los casos son válidos.
    }

    private boolean checkDate(int day, int month, int year) throws Exception{
        if(checkLeap(year))
        {
            return isValidDate(day,month,year);
        } else {
            return isValidDate(day,month,year) && (month != 2 || day <= 28);
        }
    }

    public int getYear()
    {
        return (bits & 0XFE00) >> 5;
    }

    public int getMonth()
    {
        return (bits & 0x1E0) >> 5;
    }

    public int getDay()
    {
        return (bits & 0x1F);
    }

    public int getBits()
    {
        return bits;
    }

    public void setBits(int bits)throws Exception{
        int year = (bits & 0xFE00) >> 9;
        int day = (bits & 0x1E0) >> 5;
        int month = (bits & 0x1F);

        if(checkDate(day, month, year))
        {
            this.bits = bits;
        } else {
            throw new Exception("La fecha introducida es invalida");
        }
    }

    public String toString(){
        return String.format("%d/%d/%d",getDay(),getMonth(),getYear());
    }

}
