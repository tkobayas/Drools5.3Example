package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            doGeneralExample();
            doNoLoopExample();
            doLockOnActiveExample();
            doDialectExample();
            doDeclareExample();
            doFromExample();
            doFromAccumulateExample();
            doFromCollectExample();
            doMemberOfExample();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            System.out.println("*****\ndone");
        }
    }

    /**
     * This method is for original example generated by jbds.
     */
    private static void doGeneralExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        facts.add(message);
        fire("Sample.drl", facts);
    }

    /**
     * "no-loop" will block loop when update() is invoked within the same rule.
     * Please comment out "no-loop" and see what's happen.
     **/
    private static void doNoLoopExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        facts.add(message);
        fire("NoLoop.drl", facts);
    }

    /**
     * If you comment out "lock-on-active true", and uncomment "no-loop",
     * infinit loop occurs. Because no-loop is affect only when update() is
     * invoked within the same rule. For that situation, "lock-on-active" is
     * useful.
     **/
    private static void doLockOnActiveExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        facts.add(message);
        fire("LockOnActive.drl", facts);
    }

    /**
     * Using "dialect", you can write a rule with java style or mvel style. for
     * more information about mvel, please visit following site. Language Guide
     * for 2.0 http://mvel.codehaus.org/Language+Guide+for+2.0
     **/
    private static void doDialectExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        facts.add(message);
        fire("Dialect.drl", facts);
    }

    /**
     * for more information about "declare", please read following document.
     * JBoss Rules 5 Reference Guide 13.5. Type Declarations
     * https://access.redhat
     * .com/knowledge/docs/en-US/JBoss_Enterprise_BRMS_Platform
     * /5/html-single/JBoss_Rules_5_Reference_Guide/index.html#Type_Declarations
     **/
    private static void doDeclareExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        facts.add(message);
        fire("Declare.drl", facts);
    }

    /**
     * for more information about "from", please read following document. JBoss
     * Rules 5 Reference Guide 16.24. The Conditional Element From
     * https://access
     * .redhat.com/knowledge/docs/en-US/JBoss_Enterprise_BRMS_Platform
     * /5/html-single
     * /JBoss_Rules_5_Reference_Guide/index.html#The_Conditional_Element_from
     **/
    private static void doFromExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        // create list of message
        List<Message> messages = new ArrayList<Message>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        messages.add(message);
        message = new Message();
        message.setMessage("Goodbye World2");
        message.setStatus(Message.GOODBYE);
        messages.add(message);
        facts.add(messages);
        fire("From.drl", facts);
    }

    /**
     * for more information, please read following document. JBoss Rules 5
     * Reference Guide 16.32. Code for the Conditional Element Accumulate's
     * Functions https://access.redhat.com/site/documentation/en-US/
     * JBoss_Enterprise_BRMS_Platform
     * /5/html-single/JBoss_Rules_5_Reference_Guide
     * /index.html#Code_for_the_Conditional_Element_accumulates_Functions
     **/
    private static void doFromAccumulateExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Item item = new Item();
        item.setName("apple");
        item.setPrice(120);
        facts.add(item);
        item = new Item();
        item.setName("banana");
        item.setPrice(100);
        facts.add(item);
        item = new Item();
        item.setName("cherry");
        item.setPrice(150);
        facts.add(item);
        fire("FromAccumulate.drl", facts);
    }

    /**
     * for more information, please read following document. JBoss Rules 5
     * Reference Guide 26.8. Pet Store Example: Evaluate Agenda Group from
     * PetStore.drl https://access.redhat.com/site/documentation/en-US/
     * JBoss_Enterprise_BRMS_Platform
     * /5/html-single/JBoss_Rules_5_Reference_Guide
     * /index.html#Pet_Store_Example_Evaluate_Agenda_Group_from_PetStore.drl
     **/
    private static void doFromCollectExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        Item item = new Item();
        item.setName("apple");
        item.setPrice(120);
        facts.add(item);
        item = new Item();
        item.setName("banana");
        item.setPrice(100);
        facts.add(item);
        item = new Item();
        item.setName("cherry");
        item.setPrice(150);
        facts.add(item);
        fire("FromCollect.drl", facts);
    }

    /**
     * for more information about "memberOf", please read following document.
     * JBoss Rules 5 Reference Guide 16.13. Options and Operators in JBoss Rules
     * https ://access.redhat.com/knowledge/docs/en-US/
     * JBoss_Enterprise_BRMS_Platform
     * /5/html-single/JBoss_Rules_5_Reference_Guide/index.html#
     * Options_and_Operators_in_JBoss_Rules
     **/
    private static void doMemberOfExample() throws Exception {
        List<Object> facts = new ArrayList<Object>();
        // create list of message
        List<Message> messages = new ArrayList<Message>();
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        messages.add(message);
        message = new Message();
        message.setMessage("Hello World2");
        message.setStatus(Message.HELLO);
        messages.add(message);
        facts.add(messages);
        // insert message which is member of list
        facts.add(messages.get(0));
        // insert message which is not member of list
        message = new Message();
        message.setMessage("Hello World3");
        message.setStatus(Message.HELLO);
        facts.add(messages);
        fire("MemberOf.drl", facts);
    }

    private static void fire(String drl, List<Object> facts) throws Exception {
        System.out.println("*****\n* Example: " + drl + "\n*****");
        KnowledgeBase kbase = readKnowledgeBase(drl);
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
                .newFileLogger(ksession, "test");
        // go !

        for (Object fact : facts) {
            ksession.insert(fact);
        }

        ksession.fireAllRules();
        logger.close();
        ksession.dispose();
    }

    private static KnowledgeBase readKnowledgeBase(String drl) throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
                .newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource(drl),
                ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

    public static class Item {

        private String name;
        private int price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}