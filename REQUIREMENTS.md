# Some ways we might expect the system to work

1. Users interact with agent in a "chat bot" manner to collect the required information, [Reference](https://python.langchain.com/docs/modules/agents/agent_types/openai_functions_agent/)
2. Leverage [linear regression](https://www.ibm.com/topics/linear-regression) algorithms and [scalable classifiers](https://www.ibm.com/topics/naive-bayes) to create predictive determinations based on collection of rules and...
3. ...minimize the amount of questions based on the users response that get the most accurate answers
4. [RAG (Retrieval-Augmented Generation)](https://blogs.nvidia.com/blog/what-is-retrieval-augmented-generation/) sourcing multi-turn conversations to leverage multiple sources of data, including chat history
5. any benefits the user may qualify for are included in the response
6. if there are no eligible benefits we do not provide reasons why, unless additional request are requested by the user
7. if some benefits can not be determined without additional information additional queries can be made, for example, a user does not provide enough information to a question - but potential benefits could be made eligible with more context
8. AI will leverage sentiment analysis to meet the user "where they are" and/or respond accordingly during the engagement
9. use a database of benefits and a rules engine to create the {{ questions }} and output the {{ answers }} without the need of generating forms
