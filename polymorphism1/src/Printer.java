public class Printer {
    private int tonerLevel = -1;
    private int pagesPrinted = 0;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }

        this.duplex = duplex;
    }

    public int addToner(int tonerAmmount) {
        if (tonerAmmount > 0 && tonerAmmount <= 100) {
            if (tonerAmmount + this.tonerLevel > 100) {
                return -1;
            } else {
                this.tonerLevel = tonerLevel + tonerAmmount;
                System.out.println(this.tonerLevel + "is the new toner level!");
                return this.tonerLevel;
            }
        } else{
            return -1;
        }
    }

    public int printPages(int pages) {
        int pagesToPrint = 0;
        if (pages >= 0) {
            if (this.duplex == true) {
                if (pages % 2 == 0) {
                    pagesToPrint = pagesToPrint + (pages / 2);
                    System.out.println("Pages printed: " + pagesToPrint);
                    this.pagesPrinted = this.pagesPrinted + pagesToPrint;
                    return pagesToPrint;
                } else {
                    pagesToPrint = pagesToPrint + ((pages / 2) + 1);
                    System.out.println("Pages printed: " + pagesToPrint);
                    this.pagesPrinted = this.pagesPrinted + pagesToPrint;
                    return pagesToPrint;
                }
            } else {
                pagesToPrint = pagesToPrint + pages;
                this.pagesPrinted = this.pagesPrinted + pagesToPrint;
                System.out.println("Pages printed: " + pagesToPrint);
                return pagesToPrint;
            }
        } else {
            pagesToPrint = -1;
            System.out.println(pagesToPrint);

            return pagesToPrint;

        }


    }


    public int getPagesPrinted() {
        return this.pagesPrinted;
    }

}
