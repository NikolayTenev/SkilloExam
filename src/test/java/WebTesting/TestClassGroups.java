
package WebTesting;

import org.testng.annotations.Test;

public class TestClassGroups {
    @Test(groups = "smoke")
    public void LoginTest() {
        System.out.println("smoke test");
    }

    @Test(groups = "smoke")
    public void LogoutTest() {
        System.out.println("Logout smoke test");
    }
    @Test(groups = "smoke")
    public void RegisterTest() {
        System.out.println("Register smoke test");
    }
}