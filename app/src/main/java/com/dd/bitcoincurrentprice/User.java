package com.dd.bitcoincurrentprice;

public class User {


    /**
     * time : {"updated":"Mar 27, 2018 20:16:00 UTC","updatedISO":"2018-03-27T20:16:00+00:00","updateduk":"Mar 27, 2018 at 21:16 BST"}
     * disclaimer : This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org
     * chartName : Bitcoin
     * bpi : {"USD":{"code":"USD","symbol":"&#36;","rate":"7,885.9500","description":"United States Dollar","rate_float":7885.95},"GBP":{"code":"GBP","symbol":"&pound;","rate":"5,572.1255","description":"British Pound Sterling","rate_float":5572.1255},"EUR":{"code":"EUR","symbol":"&euro;","rate":"6,361.4618","description":"Euro","rate_float":6361.4618}}
     */

    private TimeBean time;
    private String disclaimer;
    private String chartName;
    private BpiBean bpi;

    public TimeBean getTime() {
        return time;
    }

    public void setTime(TimeBean time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public BpiBean getBpi() {
        return bpi;
    }

    public void setBpi(BpiBean bpi) {
        this.bpi = bpi;
    }

    public static class TimeBean {
        /**
         * updated : Mar 27, 2018 20:16:00 UTC
         * updatedISO : 2018-03-27T20:16:00+00:00
         * updateduk : Mar 27, 2018 at 21:16 BST
         */

        private String updated;
        private String updatedISO;
        private String updateduk;

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getUpdatedISO() {
            return updatedISO;
        }

        public void setUpdatedISO(String updatedISO) {
            this.updatedISO = updatedISO;
        }

        public String getUpdateduk() {
            return updateduk;
        }

        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }
    }

    public static class BpiBean {
        /**
         * USD : {"code":"USD","symbol":"&#36;","rate":"7,885.9500","description":"United States Dollar","rate_float":7885.95}
         * GBP : {"code":"GBP","symbol":"&pound;","rate":"5,572.1255","description":"British Pound Sterling","rate_float":5572.1255}
         * EUR : {"code":"EUR","symbol":"&euro;","rate":"6,361.4618","description":"Euro","rate_float":6361.4618}
         */

        private USDBean USD;
        private GBPBean GBP;
        private EURBean EUR;

        public USDBean getUSD() {
            return USD;
        }

        public void setUSD(USDBean USD) {
            this.USD = USD;
        }

        public GBPBean getGBP() {
            return GBP;
        }

        public void setGBP(GBPBean GBP) {
            this.GBP = GBP;
        }

        public EURBean getEUR() {
            return EUR;
        }

        public void setEUR(EURBean EUR) {
            this.EUR = EUR;
        }

        public static class USDBean {
            /**
             * code : USD
             * symbol : &#36;
             * rate : 7,885.9500
             * description : United States Dollar
             * rate_float : 7885.95
             */

            private String code;
            private String symbol;
            private String rate;
            private String description;
            private double rate_float;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public double getRate_float() {
                return rate_float;
            }

            public void setRate_float(double rate_float) {
                this.rate_float = rate_float;
            }
        }

        public static class GBPBean {
            /**
             * code : GBP
             * symbol : &pound;
             * rate : 5,572.1255
             * description : British Pound Sterling
             * rate_float : 5572.1255
             */

            private String code;
            private String symbol;
            private String rate;
            private String description;
            private double rate_float;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public double getRate_float() {
                return rate_float;
            }

            public void setRate_float(double rate_float) {
                this.rate_float = rate_float;
            }
        }

        public static class EURBean {
            /**
             * code : EUR
             * symbol : &euro;
             * rate : 6,361.4618
             * description : Euro
             * rate_float : 6361.4618
             */

            private String code;
            private String symbol;
            private String rate;
            private String description;
            private double rate_float;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public double getRate_float() {
                return rate_float;
            }

            public void setRate_float(double rate_float) {
                this.rate_float = rate_float;
            }
        }
    }
}
