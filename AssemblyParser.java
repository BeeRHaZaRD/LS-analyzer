import java.util.List;

public class AssemblyParser {
    private int tmpCnt = 0;
    private String generateTmpName() {
        return "tmp_" + tmpCnt++;
    }

    private int labelCnt = 0;
    private String generateLabelName() {
        return "L" + labelCnt++;
    }

    public void printAssemblerTree(Tree root) {
        List<Tree> children = root.getChildren();

        Tree operators;
        if (children != null && children.size() > 1) {
            System.out.println("START");
            operators = children.get(1);

            children = operators.getChildren();

            if (children != null) {
                operators = children.get(0);
            } else {
                System.out.println("// Empty program!");
                return;
            }
        } else {
            System.out.println("// Empty program!");
            return;
        }

        printAssemblerOperators(operators);
        System.out.println("END");
    }

    private void printAssemblerOperators(Tree node) {

        switch (node.getName()) {
            case "Operators":
                for (Tree child : node.getChildren()) {
                    printAssemblerOperators(child);
                }
                break;
            case "Operator":
                printAssemblerAppropriateOperator(node.getChildren().get(0));
                break;
            case "If":
                printAssemblerIf(node);
                break;
            case "IfElse":
                printAssemblerIfElse(node);
                break;
            default:
                System.out.println("SOME ERROR");
                break;
        }
    }

    private void printAssemblerAppropriateOperator(Tree node) {
        List<Tree> children = node.getChildren();
        String x = children.get(0).getName();

        switch (children.get(1).getType()) {
            case "Const":
            case "Identifier":
                String y = children.get(1).getName();
                System.out.printf("%s %s %s%n", x, node.getName(), y);
                break;
            case "Expression":
                String tmpName = generateTmpName();
                printAssemblerExpression(children.get(1), tmpName);
                System.out.printf("%s %s %s%n", x, node.getName(), tmpName);
                break;
            default:
                System.out.println("SOME SHIT!");
                break;
        }
    }

    private void printAssemblerExpression(Tree node, String curName) {
        List<Tree> children = node.getChildren();

        String y;
        switch (children.get(0).getType()) {
            case "Expression":
                y = generateTmpName();
                printAssemblerExpression(children.get(0), y);
                break;
            case "Const":
            case "Identifier":
                y = children.get(0).getName();
                break;
            default:
                System.out.println("SOME SHIT!");
                y = "ERROR";
                break;
        }

        switch (children.get(1).getType()) {
            case "Binary operator":
                String z;
                switch (children.get(2).getType()) {
                    case "Expression":
                        z = generateTmpName();
                        printAssemblerExpression(children.get(2), z);
                        break;
                    case "Const":
                    case "Identifier":
                        z = children.get(2).getName();
                        break;
                    default:
                        System.out.println("SOME SHIT!");
                        z = "ERROR";
                        break;
                }
                System.out.printf("%s = %s %s %s%n", curName, y, children.get(1).getName(), z);
                break;
            case "Unary operator":
                System.out.printf("%s = %s %s%n", curName, children.get(1).getName(), y);
                break;
            default:
                System.out.println("SOME SHIT!");
                break;
        }
    }

    private void printAssemblerIf(Tree node) {
        String falseConditionLabel = generateLabelName();

        String exp = generateTmpName();
        printAssemblerExpression(node.getChildren().get(0), exp);

        System.out.printf("if_false %s goto %s\n", exp, falseConditionLabel);

        printAssemblerOperators(node.getChildren().get(1));

        System.out.println(falseConditionLabel + ":");
    }

    private void printAssemblerIfElse(Tree node) {
        String elseLabel = generateLabelName();
        String trueConditionLabel = generateLabelName();


        String exp = generateTmpName();
        printAssemblerExpression(node.getChildren().get(0), exp);
        System.out.printf("if_false %s goto %s\n", exp, elseLabel);

        printAssemblerOperators(node.getChildren().get(1));
        System.out.printf("goto %s\n", trueConditionLabel);
        System.out.println(elseLabel + ":");

        printAssemblerOperators(node.getChildren().get(2));
        System.out.println(trueConditionLabel + ":");
    }
}
