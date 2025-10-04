import java.util.concurrent.CompletableFuture;

public class EnchantedForest {

    protected CompletableFuture<Void> tapWellAsync() {
        return CompletableFuture.runAsync(() -> {
           CompletableFuture<Void> extractWater = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            extractWater.join();
        });
    }

    protected CompletableFuture<Void> tearsOfTheSimurghAsync() {
        return CompletableFuture.runAsync(() -> {
           CompletableFuture<Void> collectTears = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            collectTears.join();
        });
    }

    protected CompletableFuture<Void> moonMarkedSoilAsync() {
        return CompletableFuture.runAsync(() -> {
            CompletableFuture<Void> moon = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            moon.join();
        });
    }

    protected CompletableFuture<Void> enchantedLeavesAsync() {
        return CompletableFuture.runAsync(() -> {
            CompletableFuture<Void> leave = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            leave.join();
        });
    }

    protected CompletableFuture<Void> ashesOfTheEternalCypressAsync() {
        return CompletableFuture.runAsync(() -> {
            CompletableFuture<Void> ash = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            ash.join();
        });
    }

    public CompletableFuture<Void> prepareFinalPotionAsync() {
        return tapWellAsync().thenRun(() -> {
            try {
                // Start enchanted leaves immediately after tap well completes
                enchantedLeavesAsync();
                // Start other tasks in parallel (order doesn't matter)
                tearsOfTheSimurghAsync();
                CompletableFuture.anyOf(moonMarkedSoilAsync(), ashesOfTheEternalCypressAsync());
            }
            catch (Exception e) {
                throw new UnsupportedOperationException();
            }
        });
    }
}
