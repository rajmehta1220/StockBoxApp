import mysql.connector
from nsetools import Nse
from bsedata.bse import BSE
import yfinance as yahooFinance

import time
starttime = time.time()

while True:

    mydb = mysql.connector.connect(
    host="127.0.0.1",
    user="root",
    password="root123$"
    )

    mycursor = mydb.cursor()
    
    #NSE API CONNECT AND UPDATE
    nse = Nse()
    nsestocks = ['INFY','BPCL', 'BHARTIARTL', 'AXISBANK', 'ADANIPORTS', 'TECHM', 'RELIANCE', 'INDUSINDBK', 'DIVISLAB', 'ULTRACEMCO', 'ADANIPORTS', 'BRITANNIA', 'APOLLOHOSP', 'TITAN', 'NTPC', 'LT', 'DRREDDY', 'TATAMOTORS', 'HINDUNILVR', 'ITC', 'ADANIENT', 'HINDALCO','ASIANPAINT','GRASIM','HCLTECH','ICICIBANK','HDFCLIFE','UPL','M&M','SBILIFE','TATACONSUM','TCS','MARUTI','HDFC','SBIN','TATASTEEL','AXISBANK','SUNPHARMA','BAJAJFINSV','KOTAKBANK']

    for i in nsestocks:
        quote = nse.get_quote(i)
        
        stockname = quote['companyName']
        stocktag = str(quote['symbol'])
        stockdate ='SYSDATE()'
        stocktype = 'NSE'
        stockprice = str(quote['lastPrice'])
        changerate = str(quote['change'])
        currency = 'INR'
        bid = str(quote['basePrice'])
        dayhigh = str(quote['dayHigh'])
        daylow = str(quote['dayLow'])
        lastfetched = 'CURRENT_TIMESTAMP()'
        prevPrice = str(quote['previousClose'])

        if stockprice == None:
            stockprice = 0
        if changerate == None:
            changerate = 0
        if bid == None:
            bid =0
        if dayhigh == None:
            dayhigh = 0
        if daylow == None:
            daylow = 0

        sql = "USE stockdb;"
        mycursor.execute(sql) 

        sql = "SET SQL_SAFE_UPDATES = 0;"
        mycursor.execute(sql)

        sql = "UPDATE stocksdatatableNSE SET stockdate = SYSDATE(), stockprice ="+stockprice+", changerate = "+changerate+", bid = "+bid+", dayhigh="+dayhigh+", daylow="+daylow+", lastfetched="+lastfetched+",prevprice="+prevPrice+" WHERE stocktag ='"+i+"';"
        print(sql)

        mycursor.execute(sql)

        mydb.commit()

        print(mycursor.rowcount, "NSE updated.")


    #BSE API CONNECT AND UPDATE
    b = BSE()
    bsestocks = ['532921', '512599', '500188', '532555', '500825', '532898', '533278', '542066', '532540', '500209', '500696', '500550', '532424', '500400', '532286', '532134', '532755', '500790', '507685', '500820', '543526', '543320', '540005', '532134', '508869', '532461', '532868', '500290', '500330', '539268']

    for i in range(len(bsestocks)):
        quote = b.getQuote(bsestocks[i])
        
        stockname = quote["companyName"]
        stocktag = quote['securityID']
        stockdate ='SYSDATE()'
        stocktype = 'BSE'
        stockprice = quote["currentValue"]
        changerate = quote['change']
        currency = 'INR'
        bid = quote['weightedAvgPrice']
        dayhigh = quote['dayHigh']
        daylow = quote['dayLow']
        lastfetched = 'CURRENT_TIMESTAMP()'
        prevPrice = quote['previousClose']

        sql = "USE stockdb;"
        mycursor.execute(sql) 

        sql = "SET SQL_SAFE_UPDATES = 0;"
        mycursor.execute(sql)

        sql = "UPDATE stocksdatatableBSE SET stockdate = SYSDATE(), stockprice ="+str(stockprice)+", changerate = "+str(changerate)+", bid = "+str(bid)+", dayhigh="+str(dayhigh)+", daylow="+str(daylow)+", lastfetched="+str(lastfetched)+",prevprice="+str(prevPrice)+" WHERE stocktag ='"+str(stocktag)+"';"
        print(sql)

        mycursor.execute(sql)

        mydb.commit()

        print(mycursor.rowcount, "BSE updated.")

    #NYSE API CONNECT AND UPDATE
    stocks = ["AAPL", "FB","NVDA","AMZN","TSLA","NIO","T","META","AUY","SNAP","SWN","SOFI","BURL","AEO","WMG","MANU","DKS","URBN","A","FUTU","SYM","HL","DY","DLTR","BVNRY","ROL","LI","IQ","F","HPQ","DIS", "AAL"]
  
    for i in range(len(stocks)):
        quote = yahooFinance.Ticker(stocks[i])

        stockname = quote.info["longName"]
        stocktag = quote.info['symbol']
        stockdate ='SYSDATE()'
        stocktype = 'NYSE'
        stockprice = quote.info['currentPrice']
        changerate = quote.info['beta']
        currency = quote.info['currency']
        bid = quote.info['bid']
        dayhigh = quote.info['dayHigh']
        daylow = quote.info['dayLow']
        lastfetched = 'CURRENT_TIMESTAMP()'
        prevPrice = quote.info['previousClose']

        if stockprice == None:
            stockprice = 0
        if changerate == None:
            changerate = 0
        if bid == None:
            bid =0
        if dayhigh == None:
            dayhigh = 0
        if daylow == None:
            daylow = 0

        sql = "USE stockdb;"
        mycursor.execute(sql) 

        sql = "SET SQL_SAFE_UPDATES = 0;"
        mycursor.execute(sql)

        sql = "UPDATE stocksdatatableNYSE SET stockdate = SYSDATE(), stockprice ="+str(stockprice)+", changerate = "+str(changerate)+", bid = "+str(bid)+", dayhigh="+str(dayhigh)+", daylow="+str(daylow)+", lastfetched="+str(lastfetched)+",prevprice="+str(prevPrice)+" WHERE stocktag ='"+str(stocktag)+"';"
        print(sql)

        mycursor.execute(sql)

        mydb.commit()

        print(mycursor.rowcount, "NYSE updated.")

    time.sleep(60.0 - ((time.time() - starttime) % 60.0))