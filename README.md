# ApiTestsOneFootball

1. for success testing process you need to install on your local machine best Buy API playground https://github.com/BestBuy/api-playground
Don't forget to launch the BestBuy server. 
The server should be run on http://localhost:3030. 

2. Download the code. I used the maven project. For the successful launch of the project run Instal script and check that everything works correctly by 'mvn clean tests'
You will see the build is failed. It's ok. One test is incorrect. I did it for demonstrating how works reporting. 
3. Launch tests. Set configuration launch "All Tests". (If you don't have such one created it by yourself and include all tests to the configuration). Run tests. You should have 8 tests. 7 passed and 1 failed.  
4. If you want to see reports you should run the next script in the terminal: mvn io.qameta.allure:allure-maven:serve
The report should generate and open in the browser automatically.


I used rest-assured library for the API testing and Allure library for the Reporting. 
Several tests use parametrization. 
