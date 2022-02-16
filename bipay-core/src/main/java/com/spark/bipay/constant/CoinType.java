package com.spark.bipay.constant;

public enum CoinType {
    Bitcoin("0","BTC"),
    Litecoin("2","LTC"),
    Dogecoin("3","DOGE"),
    Ethereum("60","ETH"),
    EthereumClassic("61","ETC"),
    Ripple("144","XRP"),
    Bitcoincash("145","BCH"),
    EOS("194","EOS"),
    TRX("195","TRX"),
    NEO("888","NEO"),
    XNE("208","XNE"),
    TEC("206","TEC"),
    GCA("500","GCA"),
    GCB("501","GCB"),
    GalaxyChain("502","GCC"),
    DASH("5","DASH"),
    ZEC("133","ZEC"),
    QTUM("2301","QTUM"),
    TECO("506","TECO"),
    CNYT("509","CNYT"),
    STO("99","STO"),
    CNT("520","CNT");

    private String code;
    private String unit;

    CoinType(String code, String unit){
        this.code=code;
        this.unit=unit;
    }

    public String getCode(){
        return this.code;
    }

    public String getUnit(){
        return this.unit;
    }

    public static CoinType codeOf(int code){
        switch (code){
            case 0: return Bitcoin;
            case 2: return Litecoin;
            case 3: return Dogecoin;
            case 60: return Ethereum;
            case 61: return EthereumClassic;
            case 144: return Ripple;
            case 145: return Bitcoincash;
            case 194: return EOS;
            case 195: return TRX;
            case 208: return XNE;
            case 500: return GCA;
            case 501: return GCB;
            case 502: return GalaxyChain;
            case 5: return DASH;
            case 133: return ZEC;
            case 2301: return QTUM;
            case 99: return STO;
            case 206: return TEC;
            case 888: return NEO;
            case 506: return TECO;
            case 509: return CNYT;
            case 520: return CNT;
        }
        return null;
    }
    public static CoinType unitOf(String unit){
        switch (unit){
            case "BTC": return Bitcoin;
            case "LTC": return Litecoin;
            case "DOGE": return Dogecoin;
            case "ETH": return Ethereum;
            case "ETC": return EthereumClassic;
            case "XRP": return Ripple;
            case "BCH": return Bitcoincash;
            case "EOS": return EOS;
            case "TRX": return TRX;
            case "XNE": return XNE;
            case "GCA": return GCA;
            case "GCB": return GCB;
            case "GC": return GalaxyChain;
            case "DASH": return DASH;
            case "ZEC": return ZEC;
            case "QTUM": return QTUM;
            case "STO": return STO;
            case "TEC": return TEC;
            case "NEO": return NEO;
            case "TECO": return TECO;
            case "CNYT": return CNYT;
            case "CNT": return CNT;
        }
        return null;
    }
}
