//Jenkins stages

// Import the Calculator class  from the package com.i27academy.builds
import com.i27academy.builds.Calculator

// Define a function called 'call' that accepts a Map parameter pipelineParams
def call(Map pipelineParams) {
    // Create a instance of the Calculator class
    Calculator calculator = new Calculator(this)
    pipeline {
        agent any 
        environment {
            // Set an environment variable APPLICATION_NAME 
            APPLICATION_NAME =  ${pipelineParams.appName}
        }

        stages {
            stage('Build') {
                steps {
                    echo "*************** Building the application *****************"
                    echo "************** Starting Building ${env.APPLICATION_NAME} application"
                }
            }
            stage ('Calculate') {
                steps {
                    script {
                        echo "Calling Calculator Method from src folder"
                        echo "***************** Printing the sum of values *****************"
                        // call the add method 
                        calculator.add(2,3)
                    }
                }
            }
            stage ('Test') {
                steps {
                    echo "Testing the project"
                }
            }

            stage ('DevDeploy') {
                steps {
                    echo "Deploying the project to dev environment"
                    script {
                        newcal.call(4,5)
                    }
                }
            }

        }
    }
}



def newcal(thirdNumber, fourthNumber) {
    return thirdNumber+fourthNumber
}


// Variable placeholder 
// Local variable : ${variable}
// Env Variable: ${env.variable}
// Parameters section: ${params.variable}
// pipelineParameters: ${pipelineParams.variable}