node {
    try {
        stage('Checkout source code to master') {
            checkout scm
        }

        stage('Run quality checks and tests') {
            bat './gradlew clean check checkQualityTest checkQualityMain'
        }

    } catch (ignored) {
        currentBuild.result = 'FAILURE'
        mail(to: 'maksimgerasimenkoqa@gmail.com',
                subject: "#${env.BUILD_NUMBER} - ${currentBuild.result}: ${env.JOB_NAME}",
                body: "<p><font size=\"4\" color=\"red\">${currentBuild.result}!</font></p>" +
                        "1. Broken build URL on <font color=\"brown\">Jenkins</font>: " +
                        "http://77.120.128.170:10000/job/" +
                        "Waverley-GitHub/job/github-jenkins/view/change-requests/job/${env.BRANCH_NAME}/${env.BUILD_NUMBER}/<br>" +
                        "2. Broken build URL on <font color=\"blue\">Blue Ocean</font>: " +
                        "http://77.120.128.170:10000/blue/organizations/jenkins/Waverley-GitHub%2Fgithub-jenkins/detail/" +
                        "${env.BRANCH_NAME}/${env.BUILD_NUMBER}/pipeline<br>" +
                        "3. Broken build URL on <font color=\"red\">Allure</font>: " +
                        "http://77.120.128.170:10000/job/Waverley-GitHub/job/github-jenkins/view/change-requests/job/" +
                        "${env.BRANCH_NAME}/${env.BUILD_NUMBER}/allure/")
    }

    finally {
        stage('Publish Allure report') {
            publish.allureReport()
        }

        stage('Publish quality reports') {
            publish.checkstyleReport()
            publish.pmdReport()
            publish.findbugsReport()
        }
    }
}
