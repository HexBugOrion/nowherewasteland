package net.vdragondev.nowhere.worldgen;

public class NowhereBiomeSource /*extends BiomeSource*/ {
    /*public static Codec<NowhereBiomeSource> CODEC =  RecordCodecBuilder.create((instance) -> {
        return instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((source) -> source.biomeRegistry),
            Codec.LONG.fieldOf("seed").stable().forGetter((source) -> source.seed))
            .apply(instance, instance.stable(NowhereBiomeSource::new));
    });

    public final Registry<Biome> biomeRegistry;
    private final NowhereBiomeSource biomeSampler;
    private final long seed;

    public NowhereBiomeSource(Registry<Biome> biomeRegistry, long seed) {
        super(BiomeGenData.LOOKUP.keySet().stream().map((k) -> () -> biomeRegistry.getOrThrow(k)));
        this.biomeRegistry = biomeRegistry;
        this.biomeSampler = Nowhere.build(seed);
        this.seed = seed;

        Nowhere.REGISTRY = this.biomeRegistry;

        for (Biome biome : this.biomeRegistry) {
            int id = this.biomeRegistry.getRawId(biome);
            if (!BuiltinBiomes.BY_RAW_ID.containsKey(id)) {
                BuiltinBiomes.BY_RAW_ID.put(id, this.biomeRegistry.getKey(biome).get());
            }
        }


    }

    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        try {
            // TODO: no crash sampler
            return this.biomeSampler.sample(this.biomeRegistry, biomeX, biomeZ);
        } catch (Exception e) {
            e.printStackTrace();
            return this.biomeRegistry.get(BiomeKeys.PLAINS);
        }
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new NowhereBiomeSource(this.biomeRegistry, seed);
    }
     */
}
