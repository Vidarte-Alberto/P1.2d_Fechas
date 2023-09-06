
public class Date {
    private int bits;
    /*private static int mDays[] = {
            31,28,31,30,31,30,31,31,30,31,30,31
    };*/

    public Date(int Bits) throws Exception{
        setBits(Bits);
    }

    public Date(int day, int month, int year) throws Exception{
        int Bits = 0;
        Bits |= day;
        Bits |= (month << 5);
        Bits |= (year << 9 );
        if(isValidDate(day, month, year))
        {
            this.bits = Bits;
        } else {
            throw new Exception("La fecha introducida es invalida");
        }
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
        if (month < 1 || month > 12 ) {
            throw new Exception("El mes fuera de rango");// Mes o día fuera de rangos válidos.
        }
        if (day < 1 || day > 31) {
            throw new Exception("El dia se encuentra fuera de rango permitido de un mes comun");
        }
        if (year < 1 || year > 8388607)
        {
            throw new Exception("El año se encuentra fuera de rango");
        }
        if (month == 2) {
            // Febrero tiene 29 días en un año bisiesto.
            if (checkLeap(year)) {
                if (day <= 29){
                    return true;
                } else {
                    String msg = String.format("El dia %d se encuentra fuera del rango del mes %d del año %d, quiere decir que no es viciesto", day, month, year);
                    throw new Exception(msg);
                }
            } else {
                if (day <= 28){
                    return true;
                } else {
                    String msg = String.format("El dia %d se encuentra fuera del rango del mes %d", day, month);
                    throw new Exception(msg);
                }
            }
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            throw new Exception("El mes unicamente contiene 30 dias");// Meses con 30 días.
        }

        return true; // El resto de los casos son válidos.
    }

    public int getYear()
    {
        return ((bits >> 9));
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
        int year = ((bits >> 9) & 0x7F);
        int month = (bits >> 5) & 0x0F;
        int day = (bits & 0x1F);

        if(isValidDate(day, month, year))
        {
            this.bits = bits;
        }
    }

    public String toString(){
        return String.format("%d/%d/%d",getDay(),getMonth(),getYear());
    }

}
