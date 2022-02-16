package com.bitwait.bitrade.socket.client;

import com.bitwait.bitrade.entity.ContractOptionCoin;
import com.bitwait.bitrade.service.ContractMarketService;
import com.bitwait.bitrade.service.ContractOptionCoinService;
import com.bitwait.bitrade.engine.ContractOptionCoinMatchFactory;
import com.bitwait.bitrade.job.ExchangePushJob;
import com.bitwait.bitrade.socket.ws.WebSocketHuobi;
import com.bitwait.bitrade.util.WebSocketConnectionManage;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class WsClientHuobi {

    private ContractOptionCoinService contractOptionCoinService;

    private ContractMarketService marketService;

    private ExchangePushJob exchangePushJob;

    private ContractOptionCoinMatchFactory matchFactory;

    public WsClientHuobi(ContractOptionCoinMatchFactory factory) {
        this.matchFactory = factory;
    }

    public void run() {

        List<ContractOptionCoin> contractOptionCoinList = contractOptionCoinService.findAll();

        try {
            URI uri = new URI("wss://api.huobi.pro/ws");// 国内不被墙的地址/wss://api.huobi.pro/ws   ws://api.huobi.br.com:443/ws   wss://api.huobiasia.vip/ws

            //URI uri = new URI("wss://api.huobiasia.pro/ws");// 国内不被墙的地址/wss://api.huobi.pro/ws   ws://api.huobi.br.com:443/ws   wss://api.huobiasia.vip/ws


            WebSocketHuobi ws = new WebSocketHuobi(uri, matchFactory, marketService, exchangePushJob);

            WebSocketConnectionManage.setWebSocket(ws);
            WebSocketConnectionManage.getClient().connect(ws);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void setContractOptionCoinService(ContractOptionCoinService service) {
        this.contractOptionCoinService = service;
    }
    public void setContractMarketService(ContractMarketService service) { this.marketService = service; }
    public void setExchangePushJob(ExchangePushJob pushJob) { this.exchangePushJob = pushJob; }
}
